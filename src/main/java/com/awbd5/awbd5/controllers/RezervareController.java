package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Rezervare;
import com.awbd5.awbd5.repositories.RezervareRepository;
import com.awbd5.awbd5.services.BookService;
import com.awbd5.awbd5.services.RezervareService;
import com.awbd5.awbd5.services.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/rezervari")
public class RezervareController {

    private final RezervareService rezervareService;
    private final BookService bookService;
    private final UtilizatorService utilizatorService;
    private final RezervareRepository rezervareRepository;
    @Autowired
    public RezervareController(RezervareService rezervareService, BookService bookService, UtilizatorService utilizatorService, RezervareRepository rezervareRepository) {
        this.rezervareService = rezervareService;
        this.bookService = bookService;
        this.utilizatorService = utilizatorService;
        this.rezervareRepository = rezervareRepository;
    }

    @GetMapping
    public String getAllRezervari(Model model) {
        List<Rezervare> rezervari = rezervareService.findAll();
        model.addAttribute("rezervari", rezervari);
        return "rezervari-list";
    }

    @GetMapping("/new")
    public String showNewRezervareForm(Model model) {
        model.addAttribute("rezervare", new Rezervare());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("utilizatori", utilizatorService.findAll());
        return "rezervari-form";
    }

    @PostMapping
    public String saveNewRezervare(@ModelAttribute("rezervare") Rezervare rezervare, RedirectAttributes redirectAttributes) {
        Long utilizatorId = rezervare.getUtilizator().getId();
        if (rezervareRepository.existsByUtilizatorId(utilizatorId)) {
            redirectAttributes.addFlashAttribute("errorMessage", "Utilizatorul are deja o rezervare!");
            return "redirect:/rezervari/new";
        }
        rezervareService.save(rezervare);
        return "redirect:/rezervari";
    }

    @GetMapping("/delete")
    public String showDeleteRezervareForm(Model model) {
        List<Rezervare> rezervari = rezervareService.findAll();
        model.addAttribute("rezervari", rezervari);
        return "rezervari-delete";
    }

    @PostMapping("/delete")
    public String deleteRezervare(@RequestParam("rezervareId") Long rezervareId){
        rezervareService.deleteById(rezervareId);
        return "redirect:/rezervari";
    }

}
