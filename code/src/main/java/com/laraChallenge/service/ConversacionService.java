package com.laraChallenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.laraChallenge.message.AskTextResponseMessage;
import com.laraChallenge.message.Button;
import com.laraChallenge.message.ButtonsMessage;
import com.laraChallenge.message.SimpleTextMessage;
import com.laraChallenge.model.Conversacion;
import com.laraChallenge.model.Employee;
import com.laraChallenge.model.Pregunta;
import com.laraChallenge.model.PreguntaMultipleChoice;
import com.laraChallenge.model.PreguntaTextoLibre;
import com.laraChallenge.model.Respuesta;
import com.laraChallenge.repository.ConversacionRepository;
import com.laraChallenge.repository.PreguntasRepository;

@Service
public class ConversacionService {
    private final SlackService slackService;
    private final ConversacionRepository conversacionRepository;
    private final PreguntasRepository preguntasRepository;
    private final String URL_WEBHOOK_TEXT = "http://localhost:8081/api/webhook/text";
    private final String URL_WEBHOOK_BUTTON = "http://localhost:8081/api/webhook/button";
    private final String URL_WEBHOOK = "http://localhost:8081/api/webhook";

    public ConversacionService(SlackService slackService, ConversacionRepository conversacionRepository, PreguntasRepository preguntasRepository) {
        this.slackService = slackService;
        this.conversacionRepository = conversacionRepository;
        this.preguntasRepository = preguntasRepository;
    }

    public Conversacion createConversacion(Employee employee, List<Pregunta> preguntas) {
    	Conversacion conversacion = new Conversacion(employee, preguntas);
    	conversacionRepository.save(conversacion);
        enviarSiguientePreguntaOFinalizar(conversacion);
        return conversacion;
    }
    
    public Conversacion createConversacion(String employeeId, List<String> preguntaIds) {
    	Employee employee = new Employee(employeeId, "Mateo Magliano");
    	List<Pregunta> preguntas = new ArrayList<>();
        for (String preguntaId : preguntaIds) {
            Optional<Pregunta> pregunta = preguntasRepository.findById(preguntaId);
            if (pregunta.isPresent()) {
                preguntas.add(pregunta.get());
            }
        }
        Conversacion conversacion = new Conversacion(employee, preguntas);
        conversacionRepository.save(conversacion);
        enviarSiguientePreguntaOFinalizar(conversacion);
        return conversacion;
    }

    public void processTextResponse(String employeeId, String respuesta) {
        Optional<Conversacion> conversacionOpt = conversacionRepository.findByEmployeeId(employeeId);
        if (conversacionOpt.isPresent()) {
            Conversacion conversacion = conversacionOpt.get();
            Pregunta preguntaActual = conversacion.obtenerPreguntaActual();
            Respuesta nuevaRespuesta = new Respuesta(preguntaActual, respuesta);
            conversacion.cargarRespuesta(nuevaRespuesta);
            conversacionRepository.save(conversacion);
            enviarSiguientePreguntaOFinalizar(conversacion);
        }
    }

    public void processButtonResponse(String employeeId, String respuesta) {
        Optional<Conversacion> conversacionOpt = conversacionRepository.findByEmployeeId(employeeId);
        if (conversacionOpt.isPresent()) {
        	Conversacion conversacion = conversacionOpt.get();
            Pregunta preguntaActual = conversacion.obtenerPreguntaActual();
            Respuesta nuevaRespuesta = new Respuesta(preguntaActual, respuesta);
            conversacion.cargarRespuesta(nuevaRespuesta);
            conversacionRepository.save(conversacion);
            enviarSiguientePreguntaOFinalizar(conversacion);
        }
    }
    
    private void enviarSiguientePreguntaOFinalizar(Conversacion conversacion) {
        if (!conversacion.isFinalizada()) {
            if (Objects.nonNull(conversacion.obtenerPreguntaActual())) {
            	enviarPregunta(conversacion);
            }
        } else {
            enviarMensajeFinal(conversacion);
        }
    }

    private void enviarPregunta(Conversacion conversacion) {
    	Pregunta pregunta = conversacion.obtenerPreguntaActual();
        if (pregunta instanceof PreguntaTextoLibre) {
            AskTextResponseMessage message = new AskTextResponseMessage();
            message.setEmployeeId(conversacion.getEmployee().getId());
            message.setBody(pregunta.getTexto());
            message.setWebhookUrl(URL_WEBHOOK_TEXT);
            message.setAskText(true);
            slackService.sendAskTextResponseMessage(message).subscribe();
            //return Mono.empty();
        } else if (pregunta instanceof PreguntaMultipleChoice) {
            ButtonsMessage message = new ButtonsMessage();
            message.setEmployeeId(conversacion.getEmployee().getId());
            message.setBody(pregunta.getTexto());
            message.setWebhookUrl(URL_WEBHOOK_BUTTON);
            List<String> opciones =((PreguntaMultipleChoice) pregunta).getOpciones();
            message.setButtons(IntStream.range(0, opciones.size())
                    .mapToObj(i -> {
                        Button button = new Button();
                        button.setLabel(opciones.get(i));
                        button.setValue(String.valueOf(i + 1));
                        return button;
                    }).collect(Collectors.toList()));
            slackService.sendButtonsMessage(message).subscribe();
        }
    }

    private void enviarMensajeFinal(Conversacion conversation) {
        SimpleTextMessage message = new SimpleTextMessage();
        message.setEmployeeId(conversation.getEmployee().getId());
        message.setBody("Gracias por contestar todas las preguntas. ¡Hablamos pronto!");
        message.setWebhookUrl("URL_WEBHOOK");
        slackService.sendSimpleTextMessage(message).subscribe();
    }

}
