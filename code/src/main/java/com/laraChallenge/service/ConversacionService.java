package com.laraChallenge.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

import reactor.core.publisher.Mono;

@Service
public class ConversacionService {
    private final SlackService slackService;
    private final ConversacionRepository conversacionRepository;
    private final String URL_WEBHOOK_TEXT = "http://localhost:8081/api/webhook/text";
    private final String URL_WEBHOOK_BUTTON = "http://localhost:8081/api/webhook/button";

    public ConversacionService(SlackService slackService, ConversacionRepository conversacionRepository) {
        this.slackService = slackService;
        this.conversacionRepository = conversacionRepository;
    }

    public Conversacion createConversacion(Employee employee, List<Pregunta> preguntas) {
    	Conversacion conversacion = new Conversacion(employee, preguntas);
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

    private Mono<Void> enviarPregunta(Conversacion conversacion) {
    	Pregunta pregunta = conversacion.obtenerPreguntaActual();
        if (pregunta instanceof PreguntaTextoLibre) {
            AskTextResponseMessage message = new AskTextResponseMessage();
            message.setEmployeeId(conversacion.getEmployee().getId());
            message.setBody(pregunta.getTexto());
            message.setWebhookUrl(URL_WEBHOOK_TEXT);
            message.setAskText(true);
            return slackService.sendAskTextResponseMessage(message);
        } else if (pregunta instanceof PreguntaMultipleChoice) {
            ButtonsMessage message = new ButtonsMessage();
            message.setEmployeeId(conversacion.getEmployee().getId());
            message.setBody(pregunta.getTexto());
            message.setWebhookUrl(URL_WEBHOOK_BUTTON);
            message.setButtons(((PreguntaMultipleChoice) pregunta).getOpciones().stream()
                .map(option -> {
                    Button button = new Button();
                    button.setLabel(option);
                    button.setValue(option);
                    return button;
                }).collect(Collectors.toList()));
            return slackService.sendButtonsMessage(message);
        }
        return Mono.empty();
    }

    private Mono<Void> enviarMensajeFinal(Conversacion conversation) {
        SimpleTextMessage message = new SimpleTextMessage();
        message.setEmployeeId(conversation.getEmployee().getId());
        message.setBody("Gracias por contestar todas las preguntas. ¡Hablamos pronto!");
        message.setWebhookUrl("http://localhost:8080/api/webhook");
        return slackService.sendSimpleTextMessage(message);
    }

}
