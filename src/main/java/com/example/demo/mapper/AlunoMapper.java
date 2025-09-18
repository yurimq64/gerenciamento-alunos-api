package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.dto.RequisicaoAtualizaAlunoDto;
import com.example.demo.dto.RequisicaoCriacaoAlunoDto;
import com.example.demo.entity.Aluno;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
	
	List<AlunoDTO> toDtoList(List<Aluno> list);

	AlunoDTO toDto(Aluno entidade);
	
	@Mapping(target = "id", ignore = true)
	Aluno toEntity(RequisicaoCriacaoAlunoDto dto);
	
	@Mapping(target = "senha", ignore = true)
	void atualizaDto(RequisicaoAtualizaAlunoDto dto, @MappingTarget Aluno entity);
	
	
}
