package com.combo.allProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Anamnese implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
