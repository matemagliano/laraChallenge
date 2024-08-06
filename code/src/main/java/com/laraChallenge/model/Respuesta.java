package com.laraChallenge.model;

public class Respuesta {

    private String id;
    private String texto;
    private int opcion;
    private Pregunta pregunta;
    
    public Respuesta(Pregunta pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.texto = respuesta;
        if (pregunta instanceof PreguntaMultipleChoice) {
        	this.opcion = ((PreguntaMultipleChoice) pregunta).getOpciones().indexOf(respuesta);
        }
    }
    
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
	public int getOpcion() {
		return opcion;
	}
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
}