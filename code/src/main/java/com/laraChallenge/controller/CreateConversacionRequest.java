package com.laraChallenge.controller;

import java.util.List;

public class CreateConversacionRequest {
	private String employeeId;
    private List<String> preguntaIds;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<String> getPreguntaIds() {
        return preguntaIds;
    }

    public void setPreguntaIds(List<String> preguntaIds) {
        this.preguntaIds = preguntaIds;
    }
}
