package com.combo.allProject.controller;

import com.combo.allProject.dto.AlunoDTO;
import com.combo.allProject.model.Aluno;
import com.combo.allProject.service.AlunoService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody AlunoDTO alunoDTO){
        System.out.println(alunoDTO);
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        System.out.println(aluno);

        Aluno alunoCreated = alunoService.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Integer id, @RequestBody AlunoDTO alunoDTO){

        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);

        Aluno alunoUpdate = alunoService.update(id,aluno);

        return ResponseEntity.status(HttpStatus.OK).body(alunoUpdate);
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Integer id){
        Aluno aluno = alunoService.getById(id);
         return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        List<Aluno> alunoList = alunoService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(alunoList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Aluno> delete(@NotNull @PathVariable Integer id){
        Aluno alunoGet = alunoService.getById(id);

        if (alunoGet != null) {
            alunoService.delete(alunoGet);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
