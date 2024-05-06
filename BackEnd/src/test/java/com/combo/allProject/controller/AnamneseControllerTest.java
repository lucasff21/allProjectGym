package com.combo.allProject.controller;

import com.combo.allProject.dto.AnamneseDTO;
import com.combo.allProject.model.Anamnese;
import com.combo.allProject.service.AnamneseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@SpringBootTest
class AnamneseControllerTest {
    @InjectMocks
    private AnamneseController anamneseController;
    @Mock
    private AnamneseService anamneseService;
    private Anamnese anamnese;

    private Anamnese anamneseNotId;
    private AnamneseDTO anamneseDTO;

    private AnamneseDTO anamneseDTOId;
    private Optional<Anamnese> anamneseOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void save() {
        when(anamneseService.save(any())).thenReturn(anamnese);

        ResponseEntity<Anamnese> anamnese1 = anamneseController.save(anamneseDTO);

        assertEquals(HttpStatus.CREATED, anamnese1.getStatusCode());
        assertNotNull(anamnese1.getBody());
        assertEquals(anamnese, anamnese1.getBody());
    }


    @Test
    void update() {
        when(anamneseService.update(any())).thenReturn(anamnese);
        when(anamneseService.findById(anyInt())).thenReturn(anamnese);

        ResponseEntity<Anamnese> anamnese1 = anamneseController.update(anamneseDTOId.getId(), anamneseDTOId);

        assertEquals(HttpStatus.OK, anamnese1.getStatusCode());
        assertNotNull(anamnese1.getBody());
        assertEquals(anamnese, anamnese1.getBody());

    }

    @Test
    void findById() {
        when(anamneseService.findById(anyInt())).thenReturn(anamnese);

        ResponseEntity<Object> anamnese1 = anamneseController.findById(anamnese.getId());

        assertNotNull(anamnese1);
        assertNotNull(anamnese1.getBody());
        assertEquals(ResponseEntity.class, anamnese1.getClass());
        assertEquals(Anamnese.class, anamnese1.getBody().getClass());
    }

    @Test
    void findAll() {
        List<Anamnese> anamneseList = new ArrayList<>();
        anamneseList.add(anamnese);

        when(anamneseService.findAll()).thenReturn(anamneseList);

        ResponseEntity<List<Anamnese>> anamnese1 = anamneseController.findAll();

        assertNotNull(anamnese1);
        assertNotNull(anamnese1.getBody());
        assertEquals(HttpStatus.OK, anamnese1.getStatusCode());
        assertInstanceOf(ResponseEntity.class, anamnese1);
        assertEquals(ArrayList.class, anamnese1.getBody().getClass());
        assertEquals(Anamnese.class, anamnese1.getBody().get(0).getClass());
    }

    @Test
    void delete() {
        when(anamneseService.findById(anyInt())).thenReturn(anamnese);
        doNothing().when(anamneseService).delete(any(Anamnese.class));


        ResponseEntity<Object> anamnese1 = anamneseController.delete(anamnese.getId());

        assertNotNull(anamnese1);
        assertEquals(HttpStatus.OK, anamnese1.getStatusCode());
        verify(anamneseService, times(1)).findById(anyInt());
        verify(anamneseService, times(1)).delete(any(Anamnese.class));

    }

    private void startUser(){
        Date data = new Date();
        anamnese = new Anamnese(1, data,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f);

        anamneseOptional = Optional.of(new Anamnese(1, data,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f));

        anamneseNotId = new Anamnese(1, data,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f);

        anamneseDTO = new AnamneseDTO(null, data,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f);

        anamneseDTOId = new AnamneseDTO(1, data,
                1.0f, 1.0f, 1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f, 1.0f);
    }
}