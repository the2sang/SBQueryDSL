package com.example.sbquerydsl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "AUTHOR_SEQ_GENERATOR",
        sequenceName = "AUTHOR_SETTINGS_SEQ", // 시퀸스 명
        initialValue = 1, // 초기 값
        allocationSize = 50 // 미리 할당 받을 시퀸스 수
)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_SEQ_GENERATOR")
    private int authorId;
    private String name;
    private String email;

    @OneToMany(targetEntity = Book.class,
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "authorId")
    private List<Book> books;
}
