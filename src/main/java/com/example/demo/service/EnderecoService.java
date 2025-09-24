package com.example.demo.service;

import com.example.demo.entity.Endereco;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAllEndereco() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> findEnderecoById(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco saveEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco updateEnderecoById(Long id, Endereco updatedEndereco) {
        return enderecoRepository.findById(id)
                .map(e -> {
                    e.setLogradouro(updatedEndereco.getLogradouro());
                    e.setNumero(updatedEndereco.getNumero());
                    e.setCep(updatedEndereco.getCep());
                    e.setComplemento(updatedEndereco.getComplemento());

                    return enderecoRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado."));
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
