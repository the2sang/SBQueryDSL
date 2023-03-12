package com.example.sbquerydsl.repository;

import com.example.sbquerydsl.dto.AuthorStatistic;
import com.example.sbquerydsl.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository<Author, Integer> {

    public Optional<Author> findAuthorByEmail(String email);

    public List<AuthorStatistic> getAuthorStatistic();

    public List<Author> getAuthors();

}
