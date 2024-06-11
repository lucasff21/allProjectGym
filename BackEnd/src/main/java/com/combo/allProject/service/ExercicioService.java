package com.combo.allProject.service;

import com.combo.allProject.model.Exercicio;
import com.combo.allProject.repository.ExercicioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {
    @Autowired
    private ExercicioRepository exercicioRepository;

    public Exercicio save(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public Exercicio update(Exercicio exercicio) {
        Optional<Exercicio> exercicioOptional = exercicioRepository.findById(exercicio.getId());

        if (exercicioOptional.isPresent()) {
            Exercicio exercicio1 = exercicioOptional.get();
            exercicio1.setId(exercicio.getId());
            return exercicioRepository.save(exercicio1);
        } else {
            throw new EntityNotFoundException("Objeto não encontrado");
        }
    }

    public Exercicio findById(Integer id){
        Optional<Exercicio> exercicioOptional = exercicioRepository.findById(id);

        if(exercicioOptional.isPresent()){
            return exercicioOptional.get();
        } else {
            throw new EntityNotFoundException("Objeto não encontrado");
        }
    }

    public List<Exercicio> findAll(){
        return exercicioRepository.findAll();
    }

    public void delete (Exercicio exercicio){
        Optional<Exercicio> exercicioOptional = exercicioRepository.findById(exercicio.getId());
        if(exercicioOptional.isPresent()){
            exercicioRepository.delete(exercicio);
        } else {
            throw new RuntimeException("Não foi possivel deletar");

        }
    }

}