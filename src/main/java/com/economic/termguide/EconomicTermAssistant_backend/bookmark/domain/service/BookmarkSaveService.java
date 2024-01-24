package com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.service;

import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.entity.Bookmark;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkSaveService {

    private final BookmarkRepository bookmarkRepository;

    public void saveBookmark(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }
}
