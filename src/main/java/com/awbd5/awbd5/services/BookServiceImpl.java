package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Book;
import com.awbd5.awbd5.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findByName(String bookName) {
        return null;
    }
    @Override
    public void saveOrUpdateBook(Book updatedBook) {

    }
}
