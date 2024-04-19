package com.combo.allProject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnamneseDTO {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd")
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
