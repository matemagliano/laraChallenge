package com.laraChallenge.message;

import java.util.Map;

public abstract class Message {
    private String employeeId;
    private String body;
    private String webhookUrl;
    private Map<String, String> webhookContext;
    
    public Message(String employeeId, String body, String webhookUrl) {
        this.employeeId = employeeId;
        this.body = body;
        this.webhookUrl = webhookUrl;
    }

    public Message(String employeeId, String body, String webhookUrl, Map<String, String> webhookContext) {
        this(employeeId, body, webhookUrl);
        this.webhookContext = webhookContext;
    }
    
    public Message() {
    	
    }
    
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWebhookUrl() {
		return webhookUrl;
	}
	public void setWebhookUrl(String webhookUrl) {
		this.webhookUrl = webhookUrl;
	}
	public Map<String, String> getWebhookContext() {
		return webhookContext;
	}
	public void setWebhookContext(Map<String, String> webhookContext) {
		this.webhookContext = webhookContext;
	}

}
