package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.service;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.dto.response.EconomicWordResponse;
import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.service.EconomicWordQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.mapper.EconomicWordMapper.mapToEconomicWord;

@Service
@RequiredArgsConstructor
public class EconomicWordGetService {

    private final EconomicWordQueryService economicWordQueryService;

    public EconomicWordResponse.EconomicWordInfoResponse getEconomicWord(Long economicWordId) {
        EconomicWord economicWord = economicWordQueryService.findEconomicWordById(economicWordId);
        EconomicWordResponse.EconomicWordInfoResponse economicWordInfoResponse = mapToEconomicWord(economicWord);
        return economicWordInfoResponse;
    }

    public List<EconomicWordResponse.EconomicWordInfoResponse> getAllEconomicWord() {
        List<EconomicWord> economicWord = economicWordQueryService.findAllEconomicWord();
        return getEconomicWordInfoResponses(economicWord);
    }

    private List<EconomicWordResponse.EconomicWordInfoResponse> getEconomicWordInfoResponses(List<EconomicWord> economicWordList) {
        List<EconomicWordResponse.EconomicWordInfoResponse> economicWordInfoResponseList = economicWordList.stream().map(economicWord -> {
            EconomicWordResponse.EconomicWordInfoResponse economicWordInfoResponse = mapToEconomicWord(economicWord);
            return economicWordInfoResponse;
        }).toList();
        return economicWordInfoResponseList;
    }
}
