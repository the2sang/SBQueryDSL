package com.example.sbquerydsl.jooq.article.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleWriteRepository extends JpaRepository<ArticleEntity, Long> {
}
