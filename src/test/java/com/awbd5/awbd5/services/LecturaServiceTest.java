package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Lectura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class LecturaServiceTest {

    @Mock
    private LecturaService lecturaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllLecturi() {
        List<Lectura> lecturi = new ArrayList<>();
        lecturi.add(new Lectura());
        lecturi.add(new Lectura());
        when(lecturaService.findAll()).thenReturn(lecturi);

        List<Lectura> result = lecturaService.findAll();

        assertEquals(2, result.size());
        verify(lecturaService).findAll();
    }

    @Test
    public void testFindLecturaById() {
        Long lecturaId = 1L;
        Lectura lectura = new Lectura();
        when(lecturaService.findById(lecturaId)).thenReturn(Optional.of(lectura));

        Optional<Lectura> result = lecturaService.findById(lecturaId);

        assertTrue(result.isPresent());
        assertEquals(lectura, result.get());
        verify(lecturaService).findById(lecturaId);
    }

    @Test
    public void testSaveLectura() {
        Lectura lectura = new Lectura();
        when(lecturaService.save(lectura)).thenReturn(lectura);

        Lectura result = lecturaService.save(lectura);

        assertEquals(lectura, result);
        verify(lecturaService).save(lectura);
    }
}
