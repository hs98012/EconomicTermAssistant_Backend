package com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookmarkResponse {

    @Getter
    @NoArgsConstructor
    public static class BookmarkInfoResponse {
        @Schema(description = "경제용어 id")
        private Long economicWordId;
        @Schema(description = "북마크 여부")
        private boolean isBookmarked;
        @Builder
        public BookmarkInfoResponse(Long economicWordId, boolean isBookmarked) {
            this.economicWordId = economicWordId;
            this.isBookmarked = isBookmarked;
        }
    }

}
