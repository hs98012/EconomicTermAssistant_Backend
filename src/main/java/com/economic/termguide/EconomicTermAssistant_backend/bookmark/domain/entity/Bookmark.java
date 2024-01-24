package com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.entity;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Bookmark {

    @Id
    @Column(name = "bookmark_id")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "economic_word_id")
    private EconomicWord economicWord;

    @Builder
    public Bookmark(String uuid, EconomicWord economicWord) {
        this.uuid = uuid;
        this.economicWord = economicWord;
    }
}
