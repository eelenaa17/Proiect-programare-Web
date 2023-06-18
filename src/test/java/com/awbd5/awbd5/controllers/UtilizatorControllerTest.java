package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Utilizator;
import com.awbd5.awbd5.services.UtilizatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UtilizatorControllerTest {
    @Mock
    private UtilizatorService utilizatorService;
    private MockMvc mockMvc;
    private UtilizatorController utilizatorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        utilizatorController = new UtilizatorController(utilizatorService);

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(utilizatorController)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    void testGetAllUtilizatori() throws Exception {
        List<Utilizator> utilizatori = new ArrayList<>();
        utilizatori.add(new Utilizator());
        utilizatori.add(new Utilizator());
        when(utilizatorService.findAll()).thenReturn(utilizatori);

        mockMvc.perform(get("/utilizatori"))
                .andExpect(status().isOk())
                .andExpect(view().name("utilizator-list"))
                .andExpect(model().attributeExists("utilizatori"))
                .andExpect(model().attribute("utilizatori", utilizatori));
    }

    @Test
    public void testShowNewUtilizatorForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/utilizatori/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("utilizator-form"));
    }

    @Test
    void testSaveNewUtilizator() throws Exception {
        Utilizator utilizator = new Utilizator();

        when(utilizatorService.save(any(Utilizator.class))).thenReturn(utilizator);

        mockMvc.perform(post("/utilizatori")
                        .flashAttr("utilizator", utilizator))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/utilizatori"));

        verify(utilizatorService).save(any(Utilizator.class));
    }

    @Test
    void testShowDeleteUtilizatorForm() throws Exception {
        List<Utilizator> utilizatori = new ArrayList<>();
        utilizatori.add(new Utilizator());
        utilizatori.add(new Utilizator());
        when(utilizatorService.findAll()).thenReturn(utilizatori);

        mockMvc.perform(get("/utilizatori/delete"))
                .andExpect(status().isOk())
                .andExpect(view().name("utilizator-delete"))
                .andExpect(model().attributeExists("utilizatori"))
                .andExpect(model().attribute("utilizatori", utilizatori));
    }

    @Test
    void testDeleteUtilizator() throws Exception {
        Long utilizatorId = 1L;

        mockMvc.perform(post("/utilizatori/delete")
                        .param("utilizatoriId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/utilizatori"));
        verify(utilizatorService).deleteById(utilizatorId);
    }

    @Test
    void testShowEditForm() throws Exception {
        Long utilizatorId = 1L;
        Utilizator utilizator = new Utilizator();
        when(utilizatorService.findById(utilizatorId)).thenReturn(Optional.of(utilizator));

        mockMvc.perform(get("/utilizatori/edit/{id}", utilizatorId))
                .andExpect(status().isOk())
                .andExpect(view().name("edit-utilizator"))
                .andExpect(model().attributeExists("utilizator"))
                .andExpect(model().attribute("utilizator", utilizator));
    }

    @Test
    void testUpdateUtilizator() throws Exception {
        Long utilizatorId = 1L;
        Utilizator utilizator = new Utilizator();
        utilizator.setId(utilizatorId);

        when(utilizatorService.findById(utilizatorId)).thenReturn(Optional.of(utilizator));
        doNothing().when(utilizatorService).saveOrUpdateUtilizator(any(Utilizator.class));

        mockMvc.perform(post("/utilizatori/edit/{id}", utilizatorId)
                        .flashAttr("utilizator", utilizator))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/utilizatori"));

        verify(utilizatorService).saveOrUpdateUtilizator(any(Utilizator.class));
    }
}
