package com.example.sbquerydsl.repository.impl;

import com.example.sbquerydsl.entity.QAuthor;
import com.example.sbquerydsl.entity.QBook;
import com.example.sbquerydsl.entity.QMember;
import com.example.sbquerydsl.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public abstract class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    protected final QAuthor author = QAuthor.author;
    protected final QBook book = QBook.book;
    protected final QMember member = QMember.member;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    @Override
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id)
                .orElseThrow(()->new IllegalArgumentException("entity not found with id " + id));
    }
}
