package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Book;
import com.awbd5.awbd5.services.AutorService;
import com.awbd5.awbd5.services.BookService;
import com.awbd5.awbd5.services.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final CategorieService categorieService;
    private final AutorService autorService;

    public BookController(BookService bookService, CategorieService categorieService, AutorService autorService) {
        this.bookService = bookService;
        this.categorieService = categorieService;
        this.autorService = autorService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books-list";
    }

    @GetMapping("/new")
    public String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categorii", categorieService.findAll());
        model.addAttribute("autori", autorService.findAll());
        return "book-form";
    }

    @PostMapping
    public String saveNewBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete")
    public String showDeleteBookForm(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book-delete";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("bookId") Long bookId) {
        bookService.deleteById(bookId);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            model.addAttribute("autori", autorService.findAll());
            model.addAttribute("categorii", categorieService.findAll());
            return "edit-book";
        }
        return null;
    }
    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book) {
        Optional<Book> existingBook = bookService.findById(id);
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setBookName(book.getBookName());
            updatedBook.setAutor(book.getAutor());
            updatedBook.setYear(book.getYear());
            updatedBook.setCategorie(book.getCategorie());
            bookService.saveOrUpdateBook(updatedBook);
            return "redirect:/books";
        }
        return null;
    }
}

