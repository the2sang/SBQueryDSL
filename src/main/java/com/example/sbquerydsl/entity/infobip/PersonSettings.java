package com.example.sbquerydsl.entity.infobip;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "PERSON_SETTINGS_SEQ_GENERATOR",
        sequenceName = "PERSON_SETTINGS_SEQ", // 시퀸스 명
        initialValue = 1, // 초기 값
        allocationSize = 50 // 미리 할당 받을 시퀸스 수
)
public class PersonSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SETTINGS_SEQ_GENERATOR")
    @Column
    private Long id;

    @Column
    private Long personId;

    public PersonSettings(Long personId) {
        this.personId = personId;
    }

}
