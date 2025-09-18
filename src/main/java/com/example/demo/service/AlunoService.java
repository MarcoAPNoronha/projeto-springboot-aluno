package com.example.demo.service;

import com.example.demo.dto.AlunoDTO;
import com.example.demo.entity.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {
    // Possui as regras de negócio

    @Autowired
    private AlunoRepository alunoRepository;


    public List<AlunoDTO> findAllAlunos(){
        //return de Lista pode existir vazio
        return alunoRepository.findAll().
                stream()
                .map(this::toAlunoDTO)
                .toList();
    }


    public Optional<AlunoDTO> findAlunoById(Long id){
        //return de objeto único pode ser vazio, pro caso de não achar.
        //Por isso o uso de Optional
        return alunoRepository.findById(id).
                map(this::toAlunoDTO);
    }


    public AlunoDTO saveAluno(Aluno aluno){
        Aluno alunoSaved = alunoRepository.save(aluno);
        return toAlunoDTO(alunoSaved);
    }


    public void deleteAluno(Long id){
        alunoRepository.deleteById(id);
    }


    public AlunoDTO updateAluno(Long id, Aluno updateAluno){
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(updateAluno.getNome());
                    aluno.setEmail((updateAluno.getEmail()));
                    aluno.setDataNasc(updateAluno.getDataNasc());
                    aluno.setSenha(updateAluno.getSenha());
                    aluno.setEndereco(updateAluno.getEndereco());

                    Aluno alunoSaved = alunoRepository.save(aluno);
                    return toAlunoDTO(alunoSaved);
                }).orElseThrow(() -> new RuntimeException("Aluno não existe")
        );
    }


    private AlunoDTO toAlunoDTO(Aluno aluno){
        return new AlunoDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getEndereco());
    }


}
