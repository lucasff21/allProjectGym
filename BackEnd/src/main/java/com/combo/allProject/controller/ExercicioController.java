package com.combo.allProject.controller;

import com.combo.allProject.dto.ExercicioDTO;
import com.combo.allProject.model.Anamnese;
import com.combo.allProject.model.Exercicio;
import com.combo.allProject.service.ExercicioService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercicio")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExercicioController {

    private ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping
    public ResponseEntity<Exercicio> save(ExercicioDTO exercicioDTO){

        System.out.println(exercicioDTO);

        try{
            Exercicio exercicio = new Exercicio();
            BeanUtils.copyProperties(exercicio, exercicioDTO);
            Exercicio exercicioSalvo = exercicioService.save(exercicio);

            return  ResponseEntity.status(HttpStatus.CREATED).body(exercicioSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> update(@PathVariable Integer id, ExercicioDTO exercicioDTO){

        Exercicio exercicioFind = exercicioService.findById(id);

        if(exercicioFind == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Exercicio exercicio = new Exercicio();
        BeanUtils.copyProperties(exercicio, exercicioDTO);
        return ResponseEntity.status(HttpStatus.OK).body(exercicioService.update(exercicio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(exercicioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Exercicio>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(exercicioService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Exercicio> delete(@NotNull @PathVariable Integer id){
        Exercicio exercicio = exercicioService.findById(id);
        if(exercicio != null){
            exercicioService.delete(exercicio);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}