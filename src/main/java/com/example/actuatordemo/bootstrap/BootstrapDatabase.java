package com.example.actuatordemo.bootstrap;

import com.example.actuatordemo.model.Book;
import com.example.actuatordemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class BootstrapDatabase {

    private final BookRepository bookRepository;

    @PostConstruct
    private void postConstruct() {
        Book bookOne = Book.builder().id(1L).author("Cox Habbema").title("Mijn koffer in Berlijn").build();
        Book bookTwo = Book.builder().id(2L).author("Willem Elsschot").title("Tsjip/De Leeuwentemmer").build();
        Book bookThree = Book.builder().id(3L).author("Tim Krabbé").title("Een tafel vol vlinders").build();
        Book bookFour = Book.builder().id(4L).author("Harry Mulisch").title("Twee vrouwen").build();
        Book bookFive = Book.builder().id(5L).author("Tommy Wieringa").title("Een mooie jonge vrouw").build();
        Book bookSix = Book.builder().id(6L).author("Youp van 't Hek").title("Ware woorden").build();
        Book bookSeven = Book.builder().id(7L).author("Harry Mulisch").title("Het theater, de brief en de waarheid").build();
        List<Book> books = List.of(bookOne, bookTwo, bookThree, bookFour, bookFive, bookSix, bookSeven);

        log.info("Bootstrapping the following books to the repository: [{}]", books);
        bookRepository.saveAll(books);
    }
}
