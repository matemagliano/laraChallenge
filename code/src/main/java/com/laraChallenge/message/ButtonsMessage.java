package com.laraChallenge.message;

import java.util.List;
import java.util.Map;

public class ButtonsMessage extends Message{
	private List<Button> buttons;
	
	public ButtonsMessage(String employeeId, String body, String webhookUrl, Map<String, String> webhookContext, List<Button> buttons) {
        super(employeeId, body, webhookUrl, webhookContext);
        this.buttons = buttons;
    }
	
	public ButtonsMessage(String employeeId, String body, String webhookUrl, List<Button> buttons) {
        super(employeeId, body, webhookUrl);
        this.buttons = buttons;
    }

	public ButtonsMessage() {
		// TODO Auto-generated constructor stub
	}

	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
	}
}
