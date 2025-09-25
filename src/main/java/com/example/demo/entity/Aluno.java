package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

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

    //---------------------------------------------------------------------

}
