package com.laraChallenge.model;

public class PreguntaTextoLibre extends Pregunta {

	public PreguntaTextoLibre(String id, String texto) {
		super(id,texto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void preguntar() {
		System.out.println(super.getTexto());
		
	}

}
