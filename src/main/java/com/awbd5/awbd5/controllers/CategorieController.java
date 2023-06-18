package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Categorie;
import com.awbd5.awbd5.services.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categorii")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {

        this.categorieService = categorieService;
    }
    @GetMapping
    public String listaCategorii(Model model) {
        List<Categorie> categorii = categorieService.findAll();
        model.addAttribute("categorii", categorii);
        return "categorii-list";
    }

}