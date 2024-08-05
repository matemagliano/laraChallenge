package com.laraChallenge.message;

import java.util.Map;

public class TextWebhookBody {
	private String type;
    private String employeeId;
    private String text;
    private Map<String, String> context;
    
    public TextWebhookBody() {
    }
    
	public TextWebhookBody(String type, String employeeId, String text, Map<String, String> context) {
		this.type = type;
		this.employeeId = employeeId;
		this.text = text;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Map<String, String> getContext() {
		return context;
	}
	public void setContext(Map<String, String> context) {
		this.context = context;
	}
    
}
