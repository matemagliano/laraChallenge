package com.laraChallenge.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laraChallenge.model.Conversacion;
import com.laraChallenge.service.ConversacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/conversacion")
@Tag(name = "Conversacion", description = "API para gestionar conversaciones")
public class ConversacionController {

    private ConversacionService conversacionService;
    
    public ConversacionController(ConversacionService conversacionService) {
        this.conversacionService = conversacionService;
    }

    @PostMapping("/create")
    @Operation(summary = "Crear una nueva conversación", description = "Crea una nueva conversación con un conjunto de preguntas")
    public void createConversacion(@Parameter(description = "Id del empleado y de las preguntas", required = true) @RequestBody CreateConversacionRequest request) {
        Conversacion conversacion = conversacionService.createConversacion(request.getEmployeeId(), request.getPreguntaIds());
    }
}
