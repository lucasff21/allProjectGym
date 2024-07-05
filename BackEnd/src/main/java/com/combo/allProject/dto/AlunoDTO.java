package com.combo.allProject.dto;

import com.combo.allProject.model.Exercicio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    private Integer id;
    private String nome;
    private String idade;
    List<Exercicio> exercicios;
    private  String  password;
    private  String  email;


}
