package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class EconomicWordResponse {

    @Getter
    public static class EconomicVocaResponse {
        private String word;

        @Builder
        public EconomicVocaResponse(String word) {
            this.word = word;
        }
    }

    @Getter
    public static class EconomicWordInfoResponse {
        private String theme;
        private String word;
        private String explanation;

        @Builder
        public EconomicWordInfoResponse(String theme, String word, String explanation) {
            this.theme = theme;
            this.word = word;
            this.explanation = explanation;
        }
    }
}
