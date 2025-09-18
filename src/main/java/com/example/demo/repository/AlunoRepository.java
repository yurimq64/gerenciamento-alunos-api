package com.example.demo.repository;

import com.example.demo.entity.Aluno;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	boolean existsByEmail(String email);
	Optional<Aluno> findByEmail(String email);
}
