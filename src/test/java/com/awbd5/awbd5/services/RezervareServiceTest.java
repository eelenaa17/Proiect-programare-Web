package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Rezervare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RezervareServiceTest {

    @Mock
    private RezervareService rezervareService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Rezervare> rezervari = new ArrayList<>();
        rezervari.add(new Rezervare());
        rezervari.add(new Rezervare());
        when(rezervareService.findAll()).thenReturn(rezervari);

        List<Rezervare> result = rezervareService.findAll();

        assertEquals(rezervari, result);
    }

    @Test
    void testFindById() {
        Long rezervareId = 1L;
        when(rezervareService.findById(rezervareId)).thenReturn(true);

        boolean result = rezervareService.findById(rezervareId);

        assertTrue(result);
    }

    @Test
    void testSave() {
        Rezervare rezervare = new Rezervare();

        when(rezervareService.save(any(Rezervare.class))).thenReturn(rezervare);

        Rezervare savedRezervare = rezervareService.save(rezervare);

        assertEquals(rezervare, savedRezervare);
    }

    @Test
    void testDeleteById() {
        Long rezervareId = 1L;

        rezervareService.deleteById(rezervareId);

        verify(rezervareService).deleteById(rezervareId);
    }

    @Test
    void testAddReservation() {
        Rezervare rezervare = new Rezervare();

        rezervareService.addReservation(rezervare);

        verify(rezervareService).addReservation(rezervare);
    }

    @Test
    void testExistsByUtilizatorId() {
        Long utilizatorId = 1L;
        when(rezervareService.existsByUtilizatorId(utilizatorId)).thenReturn(true);

        boolean result = rezervareService.existsByUtilizatorId(utilizatorId);

        assertTrue(result);
    }
}
