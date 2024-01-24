package com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.service;

import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.dto.response.BookmarkResponse;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.application.mapper.BookmarkMapper;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.service.BookmarkQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkGetService {

    private final BookmarkQueryService bookmarkQueryService;

    public List<BookmarkResponse.BookmarkInfoResponse> getBookmark(String uuid) {
        return bookmarkQueryService.findByUuid(uuid)
                .stream().map(bookmark -> BookmarkMapper.mapToBookmarkInfoResponse(bookmark))
                .toList();
    }
}
