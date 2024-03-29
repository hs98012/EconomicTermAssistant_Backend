package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.repository;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EconomicWordRepository extends JpaRepository<EconomicWord, Long> {

        EconomicWord findEconomicWordById(Long economicWordId);

        List<EconomicWord> findByWordStartingWith(String economicPrefix);
}
