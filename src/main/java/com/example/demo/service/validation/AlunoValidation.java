package com.example.demo.service.validation;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Aluno;
import com.example.demo.exception.AlunoExistenteException;
import com.example.demo.exception.AlunoNaoExisteException;
import com.example.demo.exception.EntidadeIrUrlDiferenteDoCorpoException;
import com.example.demo.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AlunoValidation {

	private final AlunoRepository alunoRepository;
	
	public Aluno obterAlunoSeExistir(Long id) {
		return alunoRepository.findById(id).orElseThrow(AlunoNaoExisteException::new);
	}
	
	public void verificaSeAlunoExistePeloEmail(String email) {
		if(alunoRepository.existsByEmail(email)) {
			throw new AlunoExistenteException();
		}
	}
	
	public void verificaSeAlunoExistePeloId(Long id) {
		if(!alunoRepository.existsById(id)) {
			throw new AlunoNaoExisteException();
		}
	}
	
	public void validaIdUrlDiferenteCorpo(Long id, String email) {
		Aluno alunoCorpo = alunoRepository.findByEmail(email).orElseThrow(AlunoNaoExisteException::new);
		if(!id.equals(alunoCorpo.getId()) ) {
			throw new EntidadeIrUrlDiferenteDoCorpoException();
		}
	}
}
