package com.example.sbquerydsl.repository.extension;

import static org.assertj.core.api.BDDAssertions.then;


import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@AllArgsConstructor
public class ExtensionTest extends TestBase {

    @Autowired
    private  ApplicationContext context;

    @Test
    void shouldCreateCustomBaseRepository() {

        // when
        var actual = context.getBeanNamesForType(CustomExtensionPersonRepository.class);

        // then
        then(actual).isNotEmpty();
    }
}
