package com.example.demo.repository;

import com.example.demo.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    //Arg1: qual objeto quero que o méthod seja executado
    // Arg2: tipo do atributo que identifica o aluno (Long)






}
