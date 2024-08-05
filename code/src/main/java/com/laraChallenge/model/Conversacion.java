package com.laraChallenge.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Conversacion {
	private String id;
    private boolean finalizada;
    private int preguntaActual;
    private List<Pregunta> preguntas;
    private List<Respuesta> respuestas;
	private Employee employee;
	
	
	public Conversacion(Employee employee, List<Pregunta> preguntas) {
        this.id = UUID.randomUUID().toString();
        this.setPreguntas(preguntas);
        this.respuestas = new ArrayList<>();
        this.preguntaActual = 0;
        this.finalizada = false;
        this.employee = employee;
    }
	
	public void cargarRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
        this.preguntaActual++;
        if (this.preguntaActual >= this.preguntas.size()) {
            this.finalizada = true;
        }
    }
	
	public Pregunta obtenerPreguntaActual() {
        if (preguntaActual < preguntas.size()) {
            return preguntas.get(preguntaActual);
        }
        return null;
    }
	
	// Getters and Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public int getPreguntaActual() {
		return preguntaActual;
	}
	public void setPreguntaActual(int preguntaActual) {
		this.preguntaActual = preguntaActual;
	}
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	public String getEmployeeId () {
		return this.employee.getId();
	}
}
