package com.example.sbquerydsl.service;

import com.example.sbquerydsl.dto.AuthorStatistic;
import com.example.sbquerydsl.entity.Author;
import com.example.sbquerydsl.entity.Book;
import com.example.sbquerydsl.repository.AuthorRepository;
import com.example.sbquerydsl.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthBookService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Author> saveAuthorsWithBooks(List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return authorRepository.findAuthorByEmail(email);
    }

    public List<AuthorStatistic> getAuthorStatistic() {
        return authorRepository.getAuthorStatistic();
    }

    public List<Author> getAuthorsWithFetchJoin() {
        return authorRepository.getAuthors();
    }

}
