package com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookmarkRequest {

    @Getter
    @NoArgsConstructor
    public static class BookmarkCreateRequest {
        @Schema(description = "사용자 식별자")
        private String uuid;
        @Schema(description = "경제용어 id")
        private Long economicWordId;

        @Builder
        public BookmarkCreateRequest(String uuid, Long economicWordId) {
            this.uuid = uuid;
            this.economicWordId = economicWordId;
        }
    }
}
