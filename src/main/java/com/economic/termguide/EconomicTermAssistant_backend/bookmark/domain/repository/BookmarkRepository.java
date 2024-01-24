package com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.repository;

import com.economic.termguide.EconomicTermAssistant_backend.bookmark.domain.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, String> {

    List<Bookmark> findByUuid(String uuid);

    void deleteByUuidAndEconomicWordId(String uuid, Long economicWordId);

    boolean existsByUuidAndEconomicWordId(String uuid, Long economicWordId);
}
