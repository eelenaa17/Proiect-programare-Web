package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Autor;
import com.awbd5.awbd5.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@SpringBootConfiguration
@Controller
@RequestMapping("/autori")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public String listaAutori(Model model) {
        List<Autor> autori = autorService.findAll();
        model.addAttribute("autori", autori);
        return "autor-list";
    }
}
