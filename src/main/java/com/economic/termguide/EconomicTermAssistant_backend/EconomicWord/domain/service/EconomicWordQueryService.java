package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.service;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.repository.EconomicWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EconomicWordQueryService {

    private final EconomicWordRepository economicWordRepository;

    public EconomicWord findEconomicWordById(Long economicWordId) {
        EconomicWord economicWord = economicWordRepository.findEconomicWordById(economicWordId);
        return economicWord;
    }

    public List<EconomicWord> findAllEconomicWord() {
        List<EconomicWord> economicWords = economicWordRepository.findAll();
        return economicWords;
    }

    public List<EconomicWord> findByWordStartingWith(String economicPrefix) {
        List<EconomicWord> economicWords = economicWordRepository.findByWordStartingWith(economicPrefix);
        return economicWords;
    }

}
