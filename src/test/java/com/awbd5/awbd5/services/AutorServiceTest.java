package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Autor;
import com.awbd5.awbd5.services.AutorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AutorServiceTest {

    @Mock
    private AutorService autorService;

    @Test
    public void testFindAll() {
        MockitoAnnotations.openMocks(this);

        List<Autor> expectedAutori = Arrays.asList(
                new Autor("Sadoveanu", "Mihail"),
                new Autor("Eminescu", "Mihai")
        );
        when(autorService.findAll()).thenReturn(expectedAutori);

        List<Autor> actualAutori = autorService.findAll();

        assertEquals(expectedAutori.size(), actualAutori.size());
        for (int i = 0; i < expectedAutori.size(); i++) {
            Autor expectedAutor = expectedAutori.get(i);
            Autor actualAutor = actualAutori.get(i);
            assertEquals(expectedAutor.getId(), actualAutor.getId());
            assertEquals(expectedAutor.getNume(), actualAutor.getNume());
            assertEquals(expectedAutor.getPrenume(), actualAutor.getPrenume());
        }

        verify(autorService).findAll();
    }
}
