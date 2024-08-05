package com.laraChallenge.message;

import java.util.Map;

public class SimpleTextMessage extends Message{

	public SimpleTextMessage(String employeeId, String body, String webhookUrl, Map<String, String> webhookContext) {
		super(employeeId, body, webhookUrl, webhookContext);
		// TODO Auto-generated constructor stub
	}

	public SimpleTextMessage(String employeeId, String body, String webhookUrl) {
		super(employeeId, body, webhookUrl);
		// TODO Auto-generated constructor stub
	}

	public SimpleTextMessage() {
		// TODO Auto-generated constructor stub
	}
	
}
