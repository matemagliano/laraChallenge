package com.laraChallenge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
	
	
	/*
	 * @Bean public CommandLineRunner testRunner(ConversacionService
	 * conversacionService, PreguntasRepository preguntasRepository) { return args
	 * -> { List<Pregunta> listPreguntas = new ArrayList<>();
	 * listPreguntas.add(preguntasRepository.findById("1").get());
	 * listPreguntas.add(preguntasRepository.findById("2").get());
	 * listPreguntas.add(preguntasRepository.findById("3").get());
	 * listPreguntas.add(preguntasRepository.findById("4").get());
	 * listPreguntas.add(preguntasRepository.findById("5").get());
	 * listPreguntas.add(preguntasRepository.findById("6").get());
	 * listPreguntas.add(preguntasRepository.findById("7").get());
	 * listPreguntas.add(preguntasRepository.findById("8").get());
	 * listPreguntas.add(preguntasRepository.findById("9").get());
	 * listPreguntas.add(preguntasRepository.findById("10").get());
	 * 
	 * Employee empleado1 = new Employee("1", "Mateo Magliano"); Conversacion
	 * conversacion = conversacionService.createConversacion(empleado1,
	 * listPreguntas);
	 * 
	 * }; }
	 */
	 
}