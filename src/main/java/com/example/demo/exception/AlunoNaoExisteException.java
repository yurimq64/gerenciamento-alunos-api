package com.example.demo.exception;

public class AlunoNaoExisteException extends RuntimeException{
	
	private static final String ALUNO_NAO_EXISTE = "O Aluno não existe";
	
	public AlunoNaoExisteException() {
		super(ALUNO_NAO_EXISTE);
	}

}
