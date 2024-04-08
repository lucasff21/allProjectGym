package com.combo.allProject.service;

import com.combo.allProject.model.Anamnese;
import com.combo.allProject.repository.AnamneseRepository;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

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
    void testFindByIdNotFoundException(){
        when(anamneseRepository.findById(anyInt())).thenThrow(new ResourceNotFoundException("Anamnese not found."));
            //Pode ser feito desta maneira
        try{
            anamneseService.findById(anamnese.getId());
        } catch (Exception e) {
            assertEquals(ResourceNotFoundException.class, e.getClass());
            assertEquals("Anamnese not found.", e.getMessage());
        }
            //OU PODE SER FEITO DESTA MANEIRA, AMBAS POSSUEM O MESMO EFEITO
        assertThrows(ResourceNotFoundException.class, () -> {
            anamneseService.findById(anamnese.getId());
        }, "Anamnese not found.");
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