package com.combo.allProject.service;

import com.combo.allProject.model.Anamnese;
import com.combo.allProject.repository.AnamneseRepository;
import jakarta.validation.constraints.NotNull;
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


    public Optional<Anamnese> findById(@NotNull Integer id){
        return anamneseRepository.findById(id);
    }

    public List<Anamnese> findAll(){
        return anamneseRepository.findAll();
    }

    public Anamnese update(@NotNull Anamnese anamnese){
        Optional<Anamnese> anamnese1 = anamneseRepository.findById(anamnese.getId());
        if(anamnese1.isPresent()){
            anamnese.setId(anamnese1.get().getId());
        }

        return anamneseRepository.save(anamnese);
    }

    public void delete(Anamnese anamnese){
       anamneseRepository.delete(anamnese);
    }
}
