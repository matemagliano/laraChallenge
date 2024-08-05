package com.laraChallenge.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laraChallenge.message.ButtonSelectedWebhookBody;
import com.laraChallenge.message.TextWebhookBody;
import com.laraChallenge.service.ConversacionService;

@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

    private final ConversacionService conversacionService;

    public WebhookController(ConversacionService conversationService) {
        this.conversacionService = conversationService;
    }

    @PostMapping("/text")
    public void handleTextWebhook(@RequestBody TextWebhookBody webhookBody) {
    	String employeeId = webhookBody.getData().getEmployeeId();
        String respuesta = webhookBody.getData().getText();
        
        conversacionService.processTextResponse(employeeId, respuesta);
    }

    @PostMapping("/button")
    public void handleButtonSelectedWebhook(@RequestBody ButtonSelectedWebhookBody webhookBody) {
    	String employeeId = webhookBody.getData().getEmployeeId();
        String respuesta = webhookBody.getData().getValue();
        
        conversacionService.processButtonResponse(employeeId, respuesta);
    }
}
