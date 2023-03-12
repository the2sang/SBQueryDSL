package com.example.sbquerydsl.repository.infobip;

import com.example.sbquerydsl.entity.infobip.Person;
import com.example.sbquerydsl.repository.extension.CustomExtendedQuerydslJpaRepository;

public interface PersonRepository extends CustomExtendedQuerydslJpaRepository<Person, Long> {
}
