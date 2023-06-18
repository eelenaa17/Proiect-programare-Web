package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Categorie;
import com.awbd5.awbd5.services.CategorieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategorieServiceTest {

    @Mock
    private CategorieService categorieService;

    @Test
    public void testFindAll() {
        MockitoAnnotations.openMocks(this);

        List<Categorie> expectedCategorii = Arrays.asList(
                new Categorie("Descriere 1"),
                new Categorie("Descriere 2")
        );
        when(categorieService.findAll()).thenReturn(expectedCategorii);

        List<Categorie> actualCategorii = categorieService.findAll();

        assertEquals(expectedCategorii, actualCategorii);
    }
}
