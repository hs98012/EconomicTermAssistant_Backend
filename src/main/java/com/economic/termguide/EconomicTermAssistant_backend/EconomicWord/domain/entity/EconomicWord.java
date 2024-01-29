package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity;


import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "경제용어")
public class EconomicWord {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "economic_word_id")
    @Schema(description = "경제용어 id")
    private Long id;

    @Schema(description = "경제용어 주제")
    private String theme;

    @Schema(description = "경제용어")
    private String word;

    @Schema(description = "경제용어 설명")
    private String explanation;

    @Builder
    public EconomicWord(String theme, String word, String explanation) {
        this.theme = theme;
        this.word = word;
        this.explanation = explanation;
    }
}
