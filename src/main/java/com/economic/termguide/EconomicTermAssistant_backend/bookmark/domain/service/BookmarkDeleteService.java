package com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.service;

import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkDeleteService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void deleteBookmark(String uuid, Long economicWordId) {
        bookmarkRepository.deleteByUuidAndEconomicWordId(uuid, economicWordId);
    }
}
