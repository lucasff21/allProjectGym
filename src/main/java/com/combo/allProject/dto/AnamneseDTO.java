package com.combo.allProject.dto;

import lombok.Data;

import java.util.Date;
@Data
public class AnamneseDTO {
    private Integer id;
    private Date data;
    private Float peso;
    private Float altura;
    private Float circunferencia_cintura;
    private Float circunferencia_quadril;
    private Float percentual_gordura;
    private Float massa_magra;
    private Float massa_gorda;
    private Float massa_muscular;
    private Float imc;

}
