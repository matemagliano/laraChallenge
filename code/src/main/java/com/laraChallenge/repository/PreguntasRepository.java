package com.laraChallenge.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.laraChallenge.model.Pregunta;
import com.laraChallenge.model.PreguntaMultipleChoice;
import com.laraChallenge.model.PreguntaTextoLibre;

@Repository
public class PreguntasRepository {
	private final Map<String, Pregunta> conversacionMap = new HashMap<>();
	
	public PreguntasRepository() {
        initData();
    }

    public void save(Pregunta pregunta) {
        conversacionMap.put(pregunta.getId(), pregunta);
    }

    public Optional<Pregunta> findById(String id) {
        return Optional.ofNullable(conversacionMap.get(id));
    }
    
    private void initData() {
        save(new PreguntaTextoLibre("1", "¿Cómo te sientes hoy?"));
        save(new PreguntaMultipleChoice("2", "¿Cómo calificarías tu experiencia?", 
            List.of("Muy mal", "Mal", "Regular", "Bien", "Muy bien")));
        save(new PreguntaTextoLibre("3", "¿Qué te gustaría mejorar en tu lugar de trabajo?"));
        save(new PreguntaTextoLibre("4", "¿Cuál ha sido el mayor desafío que has enfrentado en tu trabajo?"));
        save(new PreguntaTextoLibre("5", "¿Qué habilidades te gustaría desarrollar más?"));
        save(new PreguntaMultipleChoice("6", "¿Cómo calificarías la comunicación en tu equipo?", 
            List.of("Muy mala", "Mala", "Regular", "Buena", "Muy buena")));
        save(new PreguntaMultipleChoice("7", "¿Cómo describirías tu carga de trabajo?", 
            List.of("Muy ligera", "Ligera", "Moderada", "Pesada", "Muy pesada")));
        save(new PreguntaMultipleChoice("8", "¿Cómo te sientes respecto a las oportunidades de crecimiento en la empresa?", 
            List.of("Muy insatisfecho", "Insatisfecho", "Neutral", "Satisfecho", "Muy satisfecho")));
        save(new PreguntaMultipleChoice("9", "¿Cómo calificarías el apoyo recibido de tu supervisor?", 
            List.of("Muy mal", "Mal", "Regular", "Bien", "Muy bien")));
        save(new PreguntaMultipleChoice("10", "¿Cómo te sientes respecto a la política de trabajo remoto?", 
            List.of("Muy en desacuerdo", "En desacuerdo", "Neutral", "De acuerdo", "Muy de acuerdo")));
        save(new PreguntaMultipleChoice("11", "¿Cómo calificarías los beneficios ofrecidos por la empresa?", 
            List.of("Muy malos", "Malos", "Regulares", "Buenos", "Muy buenos")));
        save(new PreguntaMultipleChoice("12", "¿Cómo describirías el ambiente laboral en la empresa?", 
            List.of("Muy tóxico", "Tóxico", "Neutral", "Agradable", "Muy agradable")));
    }
}

