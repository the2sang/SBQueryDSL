package com.example.sbquerydsl.repository.extension;

import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

public class CustomExtendedQuerydslJpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
        extends ExtendedQuerydslJpaRepositoryFactoryBean<T, S, ID> {

    public CustomExtendedQuerydslJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }
}
