package com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.mapper;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.response.BookmarkResponse;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.entity.Bookmark;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BookmarkMapper {
    public static Bookmark mapToBookmark(String uuid, EconomicWord economicWord) {
        return Bookmark.builder()
                .uuid(uuid)
                .economicWord(economicWord)
                .build();
    }
    public static BookmarkResponse.BookmarkInfoResponse mapToBookmarkInfoResponse(Bookmark bookmark) {
        return BookmarkResponse.BookmarkInfoResponse.builder()
                .economicWordId(bookmark.getEconomicWord().getId())
                .build();
    }

}
