package com.laraChallenge.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.laraChallenge.model.Conversacion;

@Repository
public class ConversacionRepository {
	private final Map<String, Conversacion> conversacionMap = new HashMap<>();

    public void save(Conversacion conversacion) {
        conversacionMap.put(conversacion.getId(), conversacion);
    }

    public Optional<Conversacion> findById(String id) {
        return Optional.ofNullable(conversacionMap.get(id));
    }

    public Optional<Conversacion> findByEmployeeId(String employeeId) {
        return conversacionMap.values().stream()
                .filter(conversacion -> conversacion.getEmployeeId().equals(employeeId))
                .findFirst();
    }
}
