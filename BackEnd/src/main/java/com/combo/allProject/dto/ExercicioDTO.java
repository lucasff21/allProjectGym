package com.combo.allProject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ExercicioDTO {
    private Integer id;
    private String grupo_muscular;
    private Integer series;
    private Integer repeticoes;
    private Float peso;
    private String observacao;
    private Date data;
}
