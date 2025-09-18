package com.example.demo.exception;

public class AlunoExistenteException extends RuntimeException{
	
	private static final String ALUNO_EXISTENTE = "O Aluno ja existe";
	
	public AlunoExistenteException() {
		super(ALUNO_EXISTENTE);
	}

}
