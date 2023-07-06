package com.example.actuatordemo.service;

import com.example.actuatordemo.model.Book;
import com.example.actuatordemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Page<Book> findBooks(Pageable pageable) {
        log.info("Retrieving all books");
        return bookRepository.findAll(pageable);
    }

    public Optional<Book> findBookById(Long id) {
        log.info("Retrieving book by ID [{}]", id);
        return bookRepository.findById(id);
    }
}
