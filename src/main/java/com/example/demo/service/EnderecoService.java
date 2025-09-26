package com.example.demo.service;

import com.example.demo.entity.Aluno;
import com.example.demo.entity.Endereco;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Endereco> findAllEndereco() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findEnderecoById(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco saveEndereco(Long alunoId, Endereco endereco) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        endereco.setAluno(aluno);

        return enderecoRepository.save(endereco);
    }

    public Endereco updateEnderecoById(Long id, Endereco updatedEndereco) {
        return enderecoRepository.findById(id)
                .map(endereco -> {
                    endereco.setLogradouro(updatedEndereco.getLogradouro());
                    endereco.setNumero(updatedEndereco.getNumero());
                    endereco.setCep(updatedEndereco.getCep());
                    endereco.setComplemento(updatedEndereco.getComplemento());

                    return enderecoRepository.save(endereco);
                })
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
