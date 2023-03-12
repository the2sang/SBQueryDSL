package com.example.sbquerydsl.repository.infobip;


import com.example.sbquerydsl.entity.infobip.PersonSettings;
import com.example.sbquerydsl.repository.extension.CustomExtendedQuerydslJpaRepository;
import com.infobip.spring.data.jpa.ExtendedQuerydslJpaRepository;

public interface PersonSettingsRepository extends CustomExtendedQuerydslJpaRepository<PersonSettings, Long> {

}
