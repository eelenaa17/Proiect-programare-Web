package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Book;
import com.awbd5.awbd5.domain.Categorie;
import com.awbd5.awbd5.domain.Rezervare;
import com.awbd5.awbd5.domain.Utilizator;
import com.awbd5.awbd5.repositories.RezervareRepository;
import com.awbd5.awbd5.services.BookService;
import com.awbd5.awbd5.services.RezervareService;
import com.awbd5.awbd5.services.UtilizatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RezervareControllerTest {
    @Mock
    private RezervareService rezervareService;
    @Mock
    private BookService bookService;
    @Mock
    private UtilizatorService utilizatorService;
    private MockMvc mockMvc;
    private RezervareController rezervareController;
    private  RezervareRepository rezervareRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        rezervareController = new RezervareController(rezervareService, bookService, utilizatorService, rezervareRepository);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(rezervareController)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void testGetAllRezervari() throws Exception {
        List<Rezervare> rezervari = new ArrayList<>();
        rezervari.add(new Rezervare());
        rezervari.add(new Rezervare());
        when(rezervareService.findAll()).thenReturn(rezervari);

        mockMvc.perform(get("/rezervari"))
                .andExpect(status().isOk())
                .andExpect(view().name("rezervari-list"))
                .andExpect(model().attributeExists("rezervari"))
                .andExpect(model().attribute("rezervari", rezervari));
    }

    @Test
    public void testShowNewRezervareForm() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        when(bookService.findAll()).thenReturn(books);

        List<Utilizator> utilizatori = new ArrayList<>();
        utilizatori.add(new Utilizator());
        utilizatori.add(new Utilizator());
        when(utilizatorService.findAll()).thenReturn(utilizatori);

        mockMvc.perform(get("/rezervari/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("rezervari-form"))
                .andExpect(model().attributeExists("rezervare"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attributeExists("utilizatori"))
                .andExpect(model().attribute("books", books))
                .andExpect(model().attribute("utilizatori", utilizatori));
    }

//    @Test
//    public void testSaveNewRezervare() throws Exception {
//        Rezervare rezervare = new Rezervare();
//        rezervare.setUtilizator(new Utilizator());
//
//        Book book = new Book();
//        Categorie categorie = new Categorie("Descriere categorie");
//        book.setCategorie(categorie);
//
//        rezervare.setBook(book);
//
//        when(rezervareService.save(any(Rezervare.class))).thenReturn(rezervare);
//
//        mockMvc.perform(post("/rezervari")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(rezervare)))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/rezervari"));
//
//        verify(rezervareService).save(any(Rezervare.class));
//    }

    @Test
    public void testShowDeleteRezervareForm() throws Exception {
        List<Rezervare> rezervari = new ArrayList<>();
        rezervari.add(new Rezervare());
        rezervari.add(new Rezervare());
        when(rezervareService.findAll()).thenReturn(rezervari);

        mockMvc.perform(get("/rezervari/delete"))
                .andExpect(status().isOk())
                .andExpect(view().name("rezervari-delete"))
                .andExpect(model().attributeExists("rezervari"))
                .andExpect(model().attribute("rezervari", rezervari));
    }

    @Test
    public void testDeleteRezervare() throws Exception {
        Long rezervareId = 1L;

        mockMvc.perform(post("/rezervari/delete")
                        .param("rezervareId", rezervareId.toString()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/rezervari"));

        verify(rezervareService).deleteById(rezervareId);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
