package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class EconomicWordResponse {

    @Getter
    public static class EconomicVocaResponse {
        @Schema(description = "경제용어")
        private String word;

        @Builder
        public EconomicVocaResponse(String word) {
            this.word = word;
        }
    }

    @Getter
    public static class EconomicWordInfoResponse {
        @Schema(description = "경제용어 id")
        private Long id;
        @Schema(description = "경제용어 주제")
        private String theme;
        @Schema(description = "경제용어")
        private String word;
        @Schema(description = "경제용어 설명")
        private String explanation;

        @Builder
        public EconomicWordInfoResponse(Long id, String theme, String word, String explanation) {
            this.id = id;
            this.theme = theme;
            this.word = word;
            this.explanation = explanation;
        }
    }
}
