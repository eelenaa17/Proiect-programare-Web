package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Categorie;
import com.awbd5.awbd5.services.CategorieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategorieControllerTest {

    @Mock
    private CategorieService categorieService;

    @Mock
    private Model model;

    @Test
    public void testListaCategorii() {
        MockitoAnnotations.openMocks(this);

        List<Categorie> expectedCategorii = Arrays.asList(
                new Categorie("Descriere 1"),
                new Categorie("Descriere 2")
        );
        when(categorieService.findAll()).thenReturn(expectedCategorii);

        CategorieController categorieController = new CategorieController(categorieService);
        String viewName = categorieController.listaCategorii(model);

        assertEquals("categorii-list", viewName);
        verify(categorieService).findAll();
        verify(model).addAttribute("categorii", expectedCategorii);
    }
}
