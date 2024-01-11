package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.presentation;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.dto.response.EconomicWordResponse;
import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.service.EconomicWordGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EconomicWordController {

    private final EconomicWordGetService economicWordGetService;

    @GetMapping("/economicWord")
    public List<EconomicWordResponse.EconomicWordInfoResponse> getAllEconomicWord() {
        return economicWordGetService.getAllEconomicWord();
    }

    @GetMapping("/economicWord/{economicWordId}")
    public EconomicWordResponse.EconomicWordInfoResponse getEconomicWord(@PathVariable Long economicWordId) {
        return economicWordGetService.getEconomicWord(economicWordId);
    }
}
