package com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookmarkRequest {

    @Getter
    @NoArgsConstructor
    public static class BookmarkCreateRequest {
        private String uuid;
        private Long economicWordId;

        @Builder
        public BookmarkCreateRequest(String uuid, Long economicWordId) {
            this.uuid = uuid;
            this.economicWordId = economicWordId;
        }
    }
}
