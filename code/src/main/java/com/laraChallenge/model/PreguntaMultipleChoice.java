package com.laraChallenge.model;

import java.util.List;

public class PreguntaMultipleChoice extends Pregunta {

    private List<String> opciones;
    
    public PreguntaMultipleChoice(String texto, List<String> opciones) {
        super(texto);
        this.opciones = opciones;
    }
    
    @Override
	public void preguntar() {
    	System.out.println(super.getTexto());
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
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
