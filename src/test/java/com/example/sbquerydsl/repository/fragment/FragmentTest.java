package com.example.sbquerydsl.repository.fragment;

import static org.assertj.core.api.BDDAssertions.then;

import com.example.sbquerydsl.entity.infobip.Person;
import com.example.sbquerydsl.repository.extension.TestBase;
import com.infobip.spring.data.jpa.QuerydslJpaFragment;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;

@AllArgsConstructor
public class FragmentTest extends TestBase {

    @Autowired
    private ApplicationContext context;

    @Test
    void shouldInjectFragmentIntoContext() {

        // when
        var actual = context.getBeanNamesForType(CustomFragmentPersonRepository.class);

        // then
        then(actual).isNotEmpty();
    }

    @Test
    void shouldInjectRepositoryIntoContext() {

        // when
        var actual = context.getBeanNamesForType(
                ResolvableType.forClassWithGenerics(QuerydslJpaFragment.class, Person.class));

        // then
        then(actual).isNotEmpty();
    }
}