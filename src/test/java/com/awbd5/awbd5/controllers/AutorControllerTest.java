package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.controllers.AutorController;
import com.awbd5.awbd5.domain.Autor;
import com.awbd5.awbd5.services.AutorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AutorControllerTest {

    @Mock
    private AutorService autorService;

    @Mock
    private Model model;

    private AutorController autorController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        autorController = new AutorController(autorService);
    }

    @Test
    public void testListaAutori() {
        List<Autor> expectedAutori = Arrays.asList(
                new Autor("Mihail", "Sadoveanu"),
                new Autor("Eminescu", "Mihai")
        );
        when(autorService.findAll()).thenReturn(expectedAutori);

        String viewName = autorController.listaAutori(model);

        assertEquals("autor-list", viewName);
        verify(autorService).findAll();
        verify(model).addAttribute("autori", expectedAutori);
    }

}

