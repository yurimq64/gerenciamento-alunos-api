package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.RequisicaoAtualizaAlunoDto;
import com.example.demo.dto.RequisicaoCriacaoAlunoDto;
import com.example.demo.entity.Aluno;
import com.example.demo.mapper.AlunoMapper;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.validation.AlunoValidation;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {


    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;
    private final AlunoValidation alunoValidation;

    public List<AlunoDTO> findAllAlunos() {
    	List<Aluno> todosAlunos = alunoRepository.findAll();
        return alunoMapper.toDtoList(todosAlunos);
    }

    public AlunoDTO findAlunoById(Long id) {
    	Aluno alunoExistente = alunoValidation.obterAlunoSeExistir(id);
        return alunoMapper.toDto(alunoExistente);
    }

    @Transactional
    public AlunoDTO saveAluno(RequisicaoCriacaoAlunoDto dto) {
    	alunoValidation.verificaSeAlunoExistePeloEmail(dto.email());
    	Aluno entity =  alunoMapper.toEntity(dto);
        alunoRepository.save(entity);
        return alunoMapper.toDto(entity);
    }

    @Transactional
    public void deleteAluno(Long id) {
        alunoValidation.verificaSeAlunoExistePeloId(id);
        alunoRepository.deleteById(id);
    }

    @Transactional
    public AlunoDTO updateAluno(Long id,RequisicaoAtualizaAlunoDto dto) {
    	Aluno alunoAtual = alunoValidation.obterAlunoSeExistir(id);
    	alunoValidation.validaIdUrlDiferenteCorpo(id, dto.email());
    	alunoMapper.atualizaDto(dto, alunoAtual);
    	return alunoMapper.toDto(alunoAtual);
    }
}
