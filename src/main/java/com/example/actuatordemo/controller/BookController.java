package com.example.actuatordemo.controller;

import com.example.actuatordemo.model.Book;
import com.example.actuatordemo.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BookController implements BookApi {

    private final BookService bookService;

    @Override
    public Page<Book> index(Pageable pageable) {
        log.info("GET books API called.");
        return bookService.findBooks(pageable);
    }

    @Override
    public ResponseEntity<Book> show(Long id) {
        log.info("GET book API called.");
        Optional<Book> bookOptional = bookService.findBookById(id);
        return ResponseEntity.of(bookOptional);
    }
}
