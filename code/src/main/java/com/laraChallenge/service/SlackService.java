package com.laraChallenge.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.laraChallenge.message.AskTextResponseMessage;
import com.laraChallenge.message.ButtonsMessage;
import com.laraChallenge.message.SimpleTextMessage;

import reactor.core.publisher.Mono;

@Service
public class SlackService {
	
	private final WebClient webClient;

    public SlackService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/v1/message").build();
    }

    public Mono<Void> sendSimpleTextMessage(SimpleTextMessage message) {
        return webClient.post()
            .body(Mono.just(message), SimpleTextMessage.class)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<Void> sendAskTextResponseMessage(AskTextResponseMessage message) {
        return webClient.post()
            .body(Mono.just(message), AskTextResponseMessage.class)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<Void> sendButtonsMessage(ButtonsMessage message) {
        return webClient.post()
            .body(Mono.just(message), ButtonsMessage.class)
            .retrieve()
            .bodyToMono(Void.class);
    }
}
