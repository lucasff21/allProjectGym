package com.combo.allProject.service;

import com.combo.allProject.model.Anamnese;
import com.combo.allProject.repository.AnamneseRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnamneseService {

    private AnamneseRepository anamneseRepository;

    public AnamneseService(AnamneseRepository anamneseRepository) {
        this.anamneseRepository = anamneseRepository;
    }

    public Anamnese save(Anamnese anamnese){

        if(anamnese == null) {
            throw new IllegalArgumentException("Object cannot be empty");
        }

        return anamneseRepository.save(anamnese);
    }


    public Anamnese findById(@NotNull Integer id){

        Optional<Anamnese> amanaOptional = anamneseRepository.findById(id);

        if(amanaOptional.isPresent()){
            return amanaOptional.get();
        }

        throw new ResourceNotFoundException("Anamnese not found.");
    }

    public List<Anamnese> findAll(){
        return anamneseRepository.findAll();
    }

    public Anamnese update(@NotNull Anamnese anamnese){

        Optional<Anamnese> anamnese1 = anamneseRepository.findById(anamnese.getId());

        anamnese1.ifPresent(value -> anamnese.setId(value.getId()));

        return anamneseRepository.save(anamnese);
    }

    public void delete(Anamnese anamnese){
       anamneseRepository.delete(anamnese);
    }
}
