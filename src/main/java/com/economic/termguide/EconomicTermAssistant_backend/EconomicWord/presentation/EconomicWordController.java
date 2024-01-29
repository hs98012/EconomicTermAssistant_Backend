package com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.presentation;

import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.dto.response.EconomicWordResponse;
import com.economic.termguide.EconomicTermAssistant_backend.EconomicWord.application.service.EconomicWordGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EconomicWordController {

    private final EconomicWordGetService economicWordGetService;

    @Operation(summary = "경제용어 전체 조회", tags = {"EconomicWordController"})
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "경제용어 전체 조회 성공"),
        @ApiResponse(responseCode = "404", description = "경제용어 전체 조회 실패")
    })
    @GetMapping("/economicWord")
    public List<EconomicWordResponse.EconomicWordInfoResponse> getAllEconomicWord() {
        return economicWordGetService.getAllEconomicWord();
    }
    @Operation(summary = "경제용어 id로 조회", tags = {"EconomicWordController"})
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "경제용어 상세 조회 성공"),
        @ApiResponse(responseCode = "404", description = "경제용어 상세 조회 실패")
    })
    @GetMapping("/economicWord/{economicWordId}")
    public EconomicWordResponse.EconomicWordInfoResponse getEconomicWord(@PathVariable Long economicWordId) {
        return economicWordGetService.getEconomicWord(economicWordId);
    }
    @Operation(summary = "경제용어 검색 조회", tags = {"EconomicWordController"})
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "경제용어 검색 조회 성공"),
        @ApiResponse(responseCode = "404", description = "경제용어 검색 조회 실패")
    })
    @GetMapping("/economicWord/list/{economicPrefix}")
    public List<EconomicWordResponse.EconomicWordInfoResponse> getEconomicWordInfoResponseByPrefix(@PathVariable String economicPrefix) {
        return economicWordGetService.getEconomicWordInfoResponseByPrefix(economicPrefix);
    }
}
