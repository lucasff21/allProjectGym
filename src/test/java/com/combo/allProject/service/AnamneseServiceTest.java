package com.combo.allProject.service;

import com.combo.allProject.model.Anamnese;
import com.combo.allProject.repository.AnamneseRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class AnamneseServiceTest {
    @InjectMocks
    private AnamneseService anamneseService;
    @Mock
    private AnamneseRepository anamneseRepository;

    private Anamnese anamnese;
    private Optional<Anamnese> anamneseOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
        when(anamneseRepository.findById(anyInt())).thenReturn(anamneseOptional);

        Anamnese response = anamneseService.findById(anamnese.getId());

        assertEquals(Anamnese.class, response.getClass());
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        Date data = new Date();
        anamnese = new Anamnese(1, data,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f);

        anamneseOptional = Optional.of(new Anamnese(1, data,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f));
    }
}