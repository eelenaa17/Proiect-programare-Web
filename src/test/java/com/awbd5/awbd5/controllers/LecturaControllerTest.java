package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Book;
import com.awbd5.awbd5.domain.Lectura;
import com.awbd5.awbd5.domain.Utilizator;
import com.awbd5.awbd5.services.LecturaService;
import com.awbd5.awbd5.services.UtilizatorService;
import com.awbd5.awbd5.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LecturaControllerTest {

    @Mock
    private LecturaService lecturaService;

    @Mock
    private UtilizatorService utilizatorService;

    @Mock
    private BookService bookService;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    private LecturaController lecturaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        lecturaController = new LecturaController(lecturaService, utilizatorService, bookService);
    }


    @Test
    public void testGetAllLecturi() {
        List<Lectura> lecturi = new ArrayList<>();
        lecturi.add(new Lectura());
        lecturi.add(new Lectura());
        when(lecturaService.findAll()).thenReturn(lecturi);

        String viewName = lecturaController.getAllLecturi(model);

        assertEquals("lecturi-list", viewName);
        verify(model).addAttribute("lecturi", lecturi);
    }

    @Test
    public void testGetNewLecturaForm() {
        List<Utilizator> utilizatori = new ArrayList<>();
        utilizatori.add(new Utilizator());
        utilizatori.add(new Utilizator());
        when(utilizatorService.findAll()).thenReturn(utilizatori);

        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookService.findAll()).thenReturn(books);

        String viewName = lecturaController.getNewLecturaForm(model);

        assertEquals("lecturi-form", viewName);
        verify(model).addAttribute(eq("lectura"), any(Lectura.class));
        verify(model).addAttribute(eq("utilizatori"), anyList());
        verify(model).addAttribute(eq("books"), anyList());
    }


    @Test
    public void testSaveNewLectura() {
        Lectura lectura = new Lectura();
        when(bindingResult.hasErrors()).thenReturn(false);

        String redirectURL = lecturaController.saveNewLectura(lectura);

        assertEquals("redirect:/lecturi", redirectURL);
        verify(lecturaService).save(lectura);
    }
}
