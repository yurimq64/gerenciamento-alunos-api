package com.example.demo.controller;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.RequisicaoAtualizaAlunoDto;
import com.example.demo.dto.RequisicaoCriacaoAlunoDto;
import com.example.demo.entity.Aluno;
import com.example.demo.service.AlunoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("aluno")
public class AlunoController {

    
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> buscarAlunos() {
    	List<AlunoDTO> listAlunos = alunoService.findAllAlunos();
        return ResponseEntity.ok(listAlunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> buscarAlunoPorId(@PathVariable Long id) {
    	AlunoDTO aluno = alunoService.findAlunoById(id);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> criarAluno(@RequestBody RequisicaoCriacaoAlunoDto dto) {
    	AlunoDTO alunoSalvo = alunoService.saveAluno(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable Long id, @RequestBody RequisicaoAtualizaAlunoDto Dto) {
    	AlunoDTO alunoAtualizado = alunoService.updateAluno(id, Dto);
        return ResponseEntity.ok(alunoAtualizado);
    }

}
