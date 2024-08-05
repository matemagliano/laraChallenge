package com.laraChallenge.message;

import java.util.Map;

public class ButtonSelectedWebhookBody {
	private String type;
	private String employeeId;
    private String value;
    private Map<String, String> context;
    
    public ButtonSelectedWebhookBody(String type, String employeeId, String value, Map<String, String> context) {
		this.type = type;
		this.employeeId = employeeId;
		this.value = value;
		this.context = context;
	}
    	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Map<String, String> getContext() {
		return context;
	}
	public void setContext(Map<String, String> context) {
		this.context = context;
	}
    
    
}
