package com.laraChallenge.message;

import java.util.Map;

public class AskTextResponseMessage extends Message{
	
	private boolean askText;
	
	public AskTextResponseMessage(String employeeId, String body, String webhookUrl, Map<String, String> webhookContext, boolean askText) {
        super(employeeId, body, webhookUrl, webhookContext);
        this.askText = askText;
    }
	
	public AskTextResponseMessage(String employeeId, String body, String webhookUrl, boolean askText) {
        super(employeeId, body, webhookUrl);
        this.askText = askText;
    }

	public AskTextResponseMessage() {
		// TODO Auto-generated constructor stub
	}

	public boolean isAskText() {
		return askText;
	}

	public void setAskText(boolean askText) {
		this.askText = askText;
	}
}
