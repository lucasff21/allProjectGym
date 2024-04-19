package com.combo.allProject.controller;

import com.combo.allProject.dto.AnamneseDTO;
import com.combo.allProject.model.Anamnese;
import com.combo.allProject.service.AnamneseService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/anamnese")
public class AnamneseController {
    @Autowired
    private AnamneseService anamneseService;

    @PostMapping
    public ResponseEntity<Anamnese> save(@RequestBody AnamneseDTO anamneseDTO) {

        Anamnese anamnese = new Anamnese();
        BeanUtils.copyProperties(anamneseDTO, anamnese);
        anamneseService.save(anamnese);

        Anamnese anamneseCreated = anamneseService.save(anamnese);

        return ResponseEntity.status(HttpStatus.CREATED).body(anamneseCreated);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Anamnese> update(@RequestBody AnamneseDTO anamneseDTO) {

        Anamnese anamnese = new Anamnese();
        BeanUtils.copyProperties(anamneseDTO, anamnese);
        anamneseService.save(anamnese);

        Anamnese anamneseCreated = anamneseService.update(anamnese);

        return ResponseEntity.ok().body(anamneseCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(anamneseService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Anamnese>> findAll(){
        List<Anamnese> anamneseList = anamneseService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(anamneseList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@NotNull @PathVariable Integer id){
       Anamnese anamneseOptional = anamneseService.findById(id);
       anamneseService.delete(anamneseOptional);
       return ResponseEntity.status(HttpStatus.OK).body("Anamnese successfully deleted ");
    }
}