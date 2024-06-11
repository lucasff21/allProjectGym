package com.combo.allProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String grupo_muscular;
    private Integer series;
    private Integer repeticoes;
    private Float peso;
    private String observacao;
    private Date data;

    @ManyToMany(mappedBy = "exercicios")
    private List<Aluno> alunos = new ArrayList<>();

}
