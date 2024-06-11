package com.combo.allProject.dto;

import com.combo.allProject.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExercicioDTO {
    private Integer id;
    private String grupo_muscular;
    private Integer series;
    private Integer repeticoes;
    private Float peso;
    private String observacao;
    private Date data;
    private List<Aluno> alunos;
}
