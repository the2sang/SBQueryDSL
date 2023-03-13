package com.example.sbquerydsl.entity.infobip;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "PERSON_SEQ_GENERATOR",
        sequenceName = "PERSON_SEQ", // 시퀸스 명
        initialValue = 1, // 초기 값
        allocationSize = 50 // 미리 할당 받을 시퀸스 수
)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ_GENERATOR")
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
