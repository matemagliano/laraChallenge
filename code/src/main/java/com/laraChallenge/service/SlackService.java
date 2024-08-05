package com.laraChallenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.laraChallenge.message.AskTextResponseMessage;
import com.laraChallenge.message.ButtonsMessage;
import com.laraChallenge.message.SimpleTextMessage;

import reactor.core.publisher.Mono;

@Service
public class SlackService {
    private final WebClient webClient;
    
    private static final Logger logger = LoggerFactory.getLogger(SlackService.class);
    
    public SlackService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
            .baseUrl("http://localhost:8080/v1/message")
				/*
				 * .filter(logRequest()) .filter(logResponse())
				 */
            .build();
    }
    
	/*
	 * private ExchangeFilterFunction logRequest() { return
	 * ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
	 * logRequestDetails(clientRequest); return Mono.just(clientRequest); }); }
	 * 
	 * private void logRequestDetails(ClientRequest request) {
	 * logger.debug("Request: {} {}", request.method(), request.url());
	 * request.headers().forEach((name, values) -> values.forEach(value ->
	 * logger.debug("{}={}", name, value)));
	 * request.body().toString().lines().forEach(line ->
	 * logger.debug("Request Body: {}", line)); }
	 * 
	 * private ExchangeFilterFunction logResponse() { return
	 * ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
	 * logResponseDetails(clientResponse); return
	 * clientResponse.bodyToMono(String.class).flatMap(body -> {
	 * logger.debug("Response Body: {}", body); return Mono.just(clientResponse);
	 * }); }); }
	 * 
	 * private void logResponseDetails(ClientResponse response) {
	 * logger.debug("Response Status: {}", response.statusCode());
	 * response.headers().asHttpHeaders().forEach((name, values) ->
	 * values.forEach(value -> logger.debug("{}={}", name, value))); }
	 */

    public Mono<Void> sendSimpleTextMessage(SimpleTextMessage message) {
        logger.debug("Sending SimpleTextMessage: {}", message);
        return webClient.post()
            .body(Mono.just(message), SimpleTextMessage.class)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<Void> sendAskTextResponseMessage(AskTextResponseMessage message) {
        logger.debug("Sending AskTextResponseMessage: {}", message);
        return webClient.post()
            .body(Mono.just(message), AskTextResponseMessage.class)
            .retrieve()
            .bodyToMono(Void.class);
    }

    public Mono<Void> sendButtonsMessage(ButtonsMessage message) {
        logger.debug("Sending ButtonsMessage: {}", message);
        return webClient.post()
            .body(Mono.just(message), ButtonsMessage.class)
            .retrieve()
            .bodyToMono(Void.class);
    }
}
