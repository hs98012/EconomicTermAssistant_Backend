package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.mapper;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.dto.response.EconomicWordResponse;
import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.domain.entity.EconomicWord;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class EconomicWordMapper {

    public static EconomicWordResponse.EconomicWordInfoResponse mapToEconomicWord(EconomicWord economicWord) {
        return EconomicWordResponse.EconomicWordInfoResponse.builder()
                .theme(economicWord.getTheme())
                .word(economicWord.getWord())
                .explanation(economicWord.getExplanation())
                .build();
    }

    public static EconomicWord mapToEconomicWordInfoResponse (EconomicWordResponse.EconomicWordInfoResponse economicWordInfoResponse) {
        return EconomicWord.builder()
                .theme(economicWordInfoResponse.getTheme())
                .word(economicWordInfoResponse.getWord())
                .explanation(economicWordInfoResponse.getExplanation())
                .build();
    }
}
