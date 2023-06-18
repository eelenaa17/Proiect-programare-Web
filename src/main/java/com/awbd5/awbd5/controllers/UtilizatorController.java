package com.awbd5.awbd5.controllers;
import com.awbd5.awbd5.domain.Utilizator;
import com.awbd5.awbd5.services.UtilizatorService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Optional;
import java.util.List;

@Controller
@RequestMapping("/utilizatori")
public class UtilizatorController {
    private final UtilizatorService utilizatorService;

    public UtilizatorController(UtilizatorService utilizatorService) {
        this.utilizatorService = utilizatorService;
    }

    @GetMapping
    public String getAllUtilizatori(Model model) {
        List<Utilizator> utilizatori = utilizatorService.findAll();
        model.addAttribute("utilizatori", utilizatori);
        return "utilizator-list";
    }

    @GetMapping("/new")
    public String showNewUtilizatorForm(Model model) {
        model.addAttribute("utilizator", new Utilizator());
        return "utilizator-form";
    }
    @PostMapping
    public String saveNewUtilizator(@ModelAttribute("utilizator") Utilizator utilizator) {
        utilizatorService.save(utilizator);
        return "redirect:/utilizatori";
    }

    @GetMapping("/delete")
    public String showDeleteUtilizatorForm(Model model) {
        List<Utilizator> utilizatori = utilizatorService.findAll();
        model.addAttribute("utilizatori", utilizatori);
        return "utilizator-delete";
    }

    @PostMapping("/delete")
    public String deleteUtilizator(@RequestParam("utilizatoriId") Long utilizatoriId){
        utilizatorService.deleteById(utilizatoriId);
        return "redirect:/utilizatori";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Utilizator> utilizator = utilizatorService.findById(id);
        if (utilizator.isPresent()) {
            model.addAttribute("utilizator", utilizator.get());
            return "edit-utilizator";
        }
        return null;
    }

    @PostMapping("/edit/{id}")
    public String updateUtilizator(@PathVariable("id") Long id, @ModelAttribute("utilizator") Utilizator utilizator) {
        Optional<Utilizator> existingUtilizator = utilizatorService.findById(id);
        if (existingUtilizator.isPresent()) {
            Utilizator updatedUtilizator = existingUtilizator.get();
            updatedUtilizator.setFirstName(utilizator.getFirstName());
            updatedUtilizator.setLastName(utilizator.getLastName());
            updatedUtilizator.setCnp(utilizator.getCnp());
            updatedUtilizator.setPhone(utilizator.getPhone());
            utilizatorService.saveOrUpdateUtilizator(updatedUtilizator);
            return "redirect:/utilizatori";
        }
        return null;
    }
}