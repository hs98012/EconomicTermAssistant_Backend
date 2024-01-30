package com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.entity;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "bookmark_id")
    @Schema(description = "북마크 id")
    private Long bookmarkId;

    @Column(name = "uuid")
    @Schema(description = "UUID")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "economic_word_id")
    @Schema(description = "경제용어")
    private EconomicWord economicWord;

    @Builder
    public Bookmark(String uuid, EconomicWord economicWord) {
        this.uuid = uuid;
        this.economicWord = economicWord;
    }
}
