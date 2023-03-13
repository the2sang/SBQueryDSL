package com.example.sbquerydsl.jooq.article.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "Article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "ARTICLE_SEQ_GENERATOR",
        sequenceName = "ARTICLE_SETTINGS_SEQ", // 시퀸스 명
        initialValue = 1, // 초기 값
        allocationSize = 50 // 미리 할당 받을 시퀸스 수
)
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTICLE_SEQ_GENERATOR")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "AUTHOR_ID", nullable = false)
    private Long authorId;

    public boolean isOwner(Long authorId) {
        return this.authorId.equals(authorId);
    }

    public void updateStates(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Builder
    public ArticleEntity(Long id, String title, String description, Long authorId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author=" + authorId +
                '}';
    }
}