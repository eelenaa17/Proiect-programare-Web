package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Lectura;
import com.awbd5.awbd5.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lecturi")
public class LecturaController {

    private final LecturaService lecturaService;
    private final UtilizatorService utilizatorService;
    private final BookService bookService;

    public LecturaController(LecturaService lecturaService, UtilizatorService utilizatorService, BookService bookService) {
        this.lecturaService = lecturaService;
        this.utilizatorService = utilizatorService;
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllLecturi(Model model) {
        List<Lectura> lecturi = lecturaService.findAll();
        model.addAttribute("lecturi", lecturi);
        return "lecturi-list";
    }

    @GetMapping("/new")
    public String getNewLecturaForm(Model model) {
        model.addAttribute("lectura", new Lectura());
        model.addAttribute("utilizatori", utilizatorService.findAll());
        model.addAttribute("books", bookService.findAll());
        return "lecturi-form";
    }

    @PostMapping
    public String saveNewLectura(@ModelAttribute("lectura") Lectura lectura) {
        lecturaService.save(lectura);
        return "redirect:/lecturi";
    }
}
