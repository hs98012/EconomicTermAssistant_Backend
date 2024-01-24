package com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.service;

import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.entity.Bookmark;
import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkQueryService {

    private final BookmarkRepository bookmarkRepository;

    public List<Bookmark> findByUuid(String uuid) {
        return bookmarkRepository.findByUuid(uuid);
    }

    public boolean existsByUuidAndEconomicWordId(String uuid, Long economicWordId) {
        return bookmarkRepository.existsByUuidAndEconomicWordId(uuid, economicWordId);
    }
}
