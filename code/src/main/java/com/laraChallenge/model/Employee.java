package com.laraChallenge.model;

import java.util.List;
public class Employee {

    private String id;
    private String nombre;
    private List<Conversacion> conversations;
    
    public Employee(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    // Getters and Setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Conversacion> getConversations() {
		return conversations;
	}
	public void setConversations(List<Conversacion> conversations) {
		this.conversations = conversations;
	}

}
