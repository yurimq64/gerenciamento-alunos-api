package com.example.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequisicaoCriacaoAlunoDto(
		@NotBlank(message = "O nome é obrigatorio!") 
		String nome,
		@NotNull(message = "A dataNascimento é obrigatoria!") 
		LocalDate dataNascimento,
		@NotBlank(message = "O email é obrigatorio!") 
		String email,
		@NotBlank(message = "A senha é obrigatoria!") 
		String senha) {

}
