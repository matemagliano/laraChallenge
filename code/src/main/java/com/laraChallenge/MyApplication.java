package com.laraChallenge;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.laraChallenge.model.Conversacion;
import com.laraChallenge.model.Employee;
import com.laraChallenge.model.Pregunta;
import com.laraChallenge.model.PreguntaMultipleChoice;
import com.laraChallenge.model.PreguntaTextoLibre;
import com.laraChallenge.service.ConversacionService;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
    
	/*
	 * @Bean public CommandLineRunner testRunner(SlackService slackService) { return
	 * args -> { AskTextResponseMessage message = new AskTextResponseMessage();
	 * message.setEmployeeId("1"); message.setBody("Test body");
	 * message.setAskText(true);
	 * message.setWebhookUrl("http://localhost:8081/api/webhook/text");
	 * 
	 * slackService.sendAskTextResponseMessage(message).subscribe(); }; }
	 */
	
	
	  @Bean public CommandLineRunner testRunner(ConversacionService conversacionService) { 
		  return args -> {
	  
			  Pregunta pregunta1 = new PreguntaTextoLibre("¿Cómo te sientes hoy?");
			  Pregunta pregunta2 = new PreguntaMultipleChoice("¿Cómo calificarías tu experiencia?", Arrays.asList("Muy mal", "Mal", "Regular", "Bien", "Muy bien"));
			  
			  Employee empleado1 = new Employee("1", "Mateo Magliano"); 
			  Conversacion conversacion = conversacionService.createConversacion(empleado1, Arrays.asList(pregunta1, pregunta2));
	  
		  }; 
	   }
	 
}