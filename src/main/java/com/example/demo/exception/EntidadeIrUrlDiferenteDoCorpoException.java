package com.example.demo.exception;

public class EntidadeIrUrlDiferenteDoCorpoException extends RuntimeException{
	
	private static final String ENTIDADE_DIFERENTE = "A entidade do ID da URL é diferente do corpo";
	
	public EntidadeIrUrlDiferenteDoCorpoException() {
		super(ENTIDADE_DIFERENTE);
	}

}
