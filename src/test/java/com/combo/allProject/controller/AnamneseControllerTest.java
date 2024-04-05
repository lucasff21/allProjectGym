package com.combo.allProject.controller;

import com.combo.allProject.dto.AnamneseDTO;
import com.combo.allProject.service.AnamneseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;

import java.util.Calendar;
import java.util.Date;



@ActiveProfiles("test")
@SpringBootTest
class AnamneseControllerTest {

    @Mock
    private AnamneseService anamneseService;
    @InjectMocks
    private AnamneseController anamneseController;

    @Test
    void save() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.APRIL, 2); // Ano, Mês (Janeiro = 0, Fevereiro = 1, ..., Dezembro = 11), Dia

        // Obtém a instância de Date a partir do Calendar
        Date date = calendar.getTime();

        AnamneseDTO anamneseDTO = new AnamneseDTO(null, date,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f);

        anamneseController.save(anamneseDTO);

    }


    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void delete() {
    }
}