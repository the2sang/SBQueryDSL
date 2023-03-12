package com.example.sbquerydsl.repository.impl;

import com.example.sbquerydsl.entity.Book;
import com.example.sbquerydsl.repository.BookRepository;
import jakarta.persistence.EntityManager;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {
    public BookRepositoryImpl(EntityManager em) {
        super(Book.class, em);
    }
}
