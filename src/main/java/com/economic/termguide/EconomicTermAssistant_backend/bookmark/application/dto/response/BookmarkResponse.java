package com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookmarkResponse {

    @Getter
    @NoArgsConstructor
    public static class BookmarkInfoResponse {
        private Long economicWordId;

        @Builder
        public BookmarkInfoResponse(Long economicWordId) {
            this.economicWordId = economicWordId;
        }
    }

}
