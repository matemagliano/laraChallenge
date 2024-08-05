package com.laraChallenge.model;

import java.util.List;

public class PreguntaMultipleChoice extends Pregunta {

    private List<String> opciones;
    
    public PreguntaMultipleChoice(String id, String texto, List<String> opciones) {
        super(id, texto);
        this.opciones = opciones;
    }
    
    @Override
	public void preguntar() {
    	System.out.println(super.getTexto());
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println(opciones.get(i));
        }
	}
    
    // Getters and Setters
	public List<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

}
