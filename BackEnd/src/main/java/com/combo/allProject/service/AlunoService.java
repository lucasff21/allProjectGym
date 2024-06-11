package com.combo.allProject.service;

import com.combo.allProject.model.Aluno;
import com.combo.allProject.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno update(Integer id, Aluno aluno){
       Optional<Aluno> alunoOptional = alunoRepository.findById(id);
       if(alunoOptional.isPresent()){
           return alunoRepository.save(aluno);
       } else {
           throw new EntityNotFoundException("Aluno not found with ID: " + aluno.getId());

       }
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Aluno getById(Integer id){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if(alunoOptional.isPresent()){
            return alunoOptional.get();
        }

        throw new ResourceNotFoundException("Aluno não encontrada.");

    }

    public void delete(Aluno aluno){
        alunoRepository.delete(aluno);
    }
}
