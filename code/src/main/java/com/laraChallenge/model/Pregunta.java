package com.laraChallenge.model;

public abstract class Pregunta {
	private String id;
    private String texto;
    
    public Pregunta(String id, String texto) {
    	this.id = id;
        this.texto = texto;
    }
    
    public abstract void preguntar();
    
    // Getters and Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
