package com.example.demo.repository;

import com.example.demo.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Optional<Endereco> findAlunoId(Long alunoId); //Procura pelo endereço do aluno e retorna o endereço
}
