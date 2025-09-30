package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Centro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID único para cada objeto
    private Long id;

    private String nome;
    private String sigla;

    @OneToMany(mappedBy = "centro", cascade = CascadeType.ALL)
    private List<Curso> cursos;


    public Centro(Long id, String nome, String sigla, List<Curso> cursos) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.cursos = cursos;
    }

    public Centro() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
