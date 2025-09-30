package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

//---------------------------------------------------------------------

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID único para cada objeto
    private Long id;
    private String nome;
    private Date dataNasc;
    private String email;
    private String bio;
    private String senha;


    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL) // Um para um com Endereco
    @JoinColumn(name = "endereco_id", referencedColumnName = "id") //Chave estrangeira
    private Endereco endereco;


    @ManyToMany
    @JoinTable(
            name = "aluno_curso",
            joinColumns = @JoinColumn(name = "aluno_id"), //Recebe 2 chaves, por isso no plural
            inverseJoinColumns = @JoinColumn(name = "curso_id") //Inverse para chave estranegira
    )
    private List<Curso> cursos;


    @ManyToMany
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplinas_id")
    )
    private List<Disciplina> disciplinas;


    //---------------------------------------------------------------------

    public Aluno() {
    }


    public Aluno(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }


    public Aluno(Long id, String nome, Date dataNasc, String email, String bio, String senha) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.bio = bio;
        this.senha = senha;
    }

    //---------------------------------------------------------------------

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    //---------------------------------------------------------------------

}
