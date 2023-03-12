package com.example.sbquerydsl.repository.fragment;

import com.example.sbquerydsl.entity.infobip.Person;
import com.infobip.spring.data.jpa.QuerydslJpaFragment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CustomFragmentPersonRepository
        extends JpaRepository<Person, Long>, QuerydslPredicateExecutor<Person>, QuerydslJpaFragment<Person> {
}