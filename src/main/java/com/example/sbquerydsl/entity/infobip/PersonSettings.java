package com.example.sbquerydsl.entity.infobip;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PersonSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long personId;

    public PersonSettings(Long personId) {
        this.personId = personId;
    }

}
