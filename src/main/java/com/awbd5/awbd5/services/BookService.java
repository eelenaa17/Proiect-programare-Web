package com.awbd5.awbd5.services;

import com.awbd5.awbd5.domain.Book;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
    Book findByName(String bookName);
    void saveOrUpdateBook(Book updatedBook);
}
