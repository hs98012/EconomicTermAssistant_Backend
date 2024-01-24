package com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.service;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.service.EconomicWordQueryService;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.request.BookmarkRequest;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.mapper.BookmarkMapper;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.entity.Bookmark;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.service.BookmarkDeleteService;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.service.BookmarkQueryService;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.service.BookmarkSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkCreateService {

    private final BookmarkSaveService bookmarkSaveService;
    private final BookmarkQueryService bookmarkQueryService;
    private final BookmarkDeleteService bookmarkdeleteService;
    private final EconomicWordQueryService economicWordQueryService;

    public void createBookmark(BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        String uuid = bookmarkCreateRequest.getUuid();
        Long economicWordId = bookmarkCreateRequest.getEconomicWordId();

        EconomicWord economicWord = economicWordQueryService.findEconomicWordById(economicWordId);
        Bookmark bookmark = BookmarkMapper.mapToBookmark(uuid, economicWord);

        bookmarkSaveService.saveBookmark(bookmark);
    }

    public void deleteBookmark(BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        String uuid = bookmarkCreateRequest.getUuid();
        Long economicWordId = bookmarkCreateRequest.getEconomicWordId();

        boolean b = bookmarkQueryService.existsByUuidAndEconomicWordId(uuid, economicWordId);

        if(b) {
            bookmarkdeleteService.deleteBookmark(uuid, economicWordId);
        }
    }

}
