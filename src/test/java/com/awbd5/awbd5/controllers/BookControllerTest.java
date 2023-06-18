package com.awbd5.awbd5.controllers;

import com.awbd5.awbd5.domain.Autor;
import com.awbd5.awbd5.domain.Book;
import com.awbd5.awbd5.domain.Categorie;
import com.awbd5.awbd5.services.AutorService;
import com.awbd5.awbd5.services.BookService;
import com.awbd5.awbd5.services.CategorieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private CategorieService categorieService;

    @Mock
    private AutorService autorService;

    @Mock
    private Model model;

    private BookController bookController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        bookController = new BookController(bookService, categorieService, autorService);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Book 1", 2021, null, null));
        books.add(new Book(2L, "Book 2", 2022, null, null));
        when(bookService.findAll()).thenReturn(books);

        String viewName = bookController.getAllBooks(model);

        assertEquals("books-list", viewName);
        verify(bookService).findAll();
        verify(model).addAttribute("books", books);
    }

    @Test
    public void testShowNewBookForm() {
        List<Categorie> categorieList = new ArrayList<>();
        when(categorieService.findAll()).thenReturn(categorieList);

        List<Autor> autorList = new ArrayList<>();
        when(autorService.findAll()).thenReturn(autorList);

        String viewName = bookController.showNewBookForm(model);

        assertEquals("book-form", viewName);
        verify(model).addAttribute(eq("book"), any(Book.class));
        verify(model).addAttribute(eq("categorii"), eq(categorieList));
        verify(model).addAttribute(eq("autori"), eq(autorList));
    }

    @Test
    public void testSaveNewBook() {
        Book book = new Book();
        book.setBookName("Book 1");
        book.setYear(2021);
        when(bookService.save(book)).thenReturn(book);

        String redirectURL = bookController.saveNewBook(book);

        assertEquals("redirect:/books", redirectURL);
        verify(bookService).save(book);
    }

    @Test
    public void testShowDeleteBookForm() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Book 1", 2021, null, null));
        books.add(new Book(2L, "Book 2", 2022, null, null));
        when(bookService.findAll()).thenReturn(books);

        String viewName = bookController.showDeleteBookForm(model);

        assertEquals("book-delete", viewName);
        verify(model).addAttribute("books", books);
    }

    @Test
    public void testDeleteBook() {
        Long bookId = 1L;

        String redirectURL = bookController.deleteBook(bookId);

        assertEquals("redirect:/books", redirectURL);
        verify(bookService).deleteById(bookId);
    }

    @Test
    public void testShowEditForm() {
        Long bookId = 1L;
        Book book = new Book(bookId, "Book 1", 2021, null, null);
        when(bookService.findById(bookId)).thenReturn(Optional.of(book));

        String viewName = bookController.showEditForm(bookId, model);

        assertEquals("edit-book", viewName);
        verify(bookService).findById(bookId);
        verify(model).addAttribute("book", book);
        verify(autorService).findAll();
        verify(categorieService).findAll();
    }

    @Test
    public void testUpdateBook() {
        Long bookId = 2L;
        Book existingBook = new Book(bookId, "Book 1", 2021, null, null);
        Book updatedBook = new Book(bookId, "Updated Book", 2022, null, null);
        when(bookService.findById(eq(bookId))).thenReturn(Optional.of(existingBook));
        doNothing().when(bookService).saveOrUpdateBook(any(Book.class));

        String redirectURL = bookController.updateBook(bookId, updatedBook);

        assertEquals("redirect:/books", redirectURL);
        verify(bookService).findById(eq(bookId));
        verify(bookService).saveOrUpdateBook(eq(updatedBook));
    }


}

