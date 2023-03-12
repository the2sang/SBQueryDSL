package com.example.sbquerydsl.controller;

import com.example.sbquerydsl.dto.AuthorStatistic;
import com.example.sbquerydsl.entity.Author;
import com.example.sbquerydsl.entity.Book;
import com.example.sbquerydsl.service.AuthBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class AuthBookController {

    @Autowired
    private AuthBookService authBookService;

    @PostMapping("/authors/book")
    public List<Author> saveAuthorsWithBooks(@RequestBody List<Author> authors) {
        return authBookService.saveAuthorsWithBooks(authors);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authBookService.getAuthors();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return authBookService.getBooks();
    }

    @GetMapping("/author/{email}")
    public Optional<Author> findAuthorByEmail(@PathVariable String email) {
        return authBookService.findAuthorByEmail(email);
    }

    @GetMapping("/authorStatistic")
    public List<AuthorStatistic> getAuthorStatistic() {
        return authBookService.getAuthorStatistic();
    }

    @GetMapping("/authors/fetchJoin")
    public List<Author> getAuthorsWithFetchJoin() {
        return authBookService.getAuthorsWithFetchJoin();
    }
}
