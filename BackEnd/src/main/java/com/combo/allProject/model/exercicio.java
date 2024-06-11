
package com.combo.allProject.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
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