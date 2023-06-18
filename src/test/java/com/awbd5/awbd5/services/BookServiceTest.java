package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Book;
import com.awbd5.awbd5.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Book> expectedBooks = Arrays.asList(
                new Book(1L, "Book 1", 2021, null, null),
                new Book(2L, "Book 2", 2022, null, null)
        );
        when(bookService.findAll()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findAll();

        assertEquals(expectedBooks, actualBooks);
        verify(bookService).findAll();
    }

    @Test
    public void testFindById() {
        Long bookId = 1L;
        Book expectedBook = new Book(bookId, "Book 1", 2021, null, null);
        when(bookService.findById(bookId)).thenReturn(Optional.of(expectedBook));

        Optional<Book> actualBook = bookService.findById(bookId);

        assertEquals(Optional.of(expectedBook), actualBook);
        verify(bookService).findById(bookId);
    }

    @Test
    public void testSave() {
        Book book = new Book(1L, "Book 1", 2021, null, null);
        when(bookService.save(book)).thenReturn(book);

        Book savedBook = bookService.save(book);

        assertEquals(book, savedBook);
        verify(bookService).save(book);
    }

    @Test
    public void testDeleteById() {
        Long bookId = 1L;

        bookService.deleteById(bookId);

        verify(bookService).deleteById(bookId);
    }

    @Test
    public void testFindByName() {
        String bookName = "Book 1";
        Book expectedBook = new Book(1L, bookName, 2021, null, null);
        when(bookService.findByName(bookName)).thenReturn(expectedBook);

        Book actualBook = bookService.findByName(bookName);

        assertEquals(expectedBook, actualBook);
        verify(bookService).findByName(bookName);
    }

    @Test
    public void testSaveOrUpdateBook() {
        Book book = new Book(1L, "Book 1", 2021, null, null);

        bookService.saveOrUpdateBook(book);

        verify(bookService).saveOrUpdateBook(book);
    }
}
