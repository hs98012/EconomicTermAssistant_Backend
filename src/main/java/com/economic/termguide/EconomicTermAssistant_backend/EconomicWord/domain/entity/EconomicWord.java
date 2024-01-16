package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class EconomicWord {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "economic_word_id")
    private Long id;

    private String theme;

    private String word;

    private String explanation;

    @Builder
    public EconomicWord(String theme, String word, String explanation) {
        this.theme = theme;
        this.word = word;
        this.explanation = explanation;
    }
}
