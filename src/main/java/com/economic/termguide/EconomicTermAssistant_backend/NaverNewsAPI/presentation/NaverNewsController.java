package com.economic.termguide.EconomicTermAssistant_backend.NaverNewsAPI.presentation;

import com.economic.termguide.EconomicTermAssistant_backend.NaverNewsAPI.application.service.NaverNewsGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NaverNewsController {

    private final NaverNewsGetService newsGetService;

    @Operation(summary = "네이버 뉴스 키워드 조회", tags = {"NaverNewsController"})
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "네이버 뉴스 키워드 조회 성공"),
        @ApiResponse(responseCode = "404", description = "네이버 뉴스 키워드 조회 실패")
    })
    @GetMapping("/naverNews/{keyword}")
    public String getNewsByKeyword(@PathVariable String keyword) {
        return newsGetService.getNewsByKeyword(keyword);
    }

    @Operation(summary = "네이버 뉴스 이미지 조회", tags = {"NaverNewsController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "네이버 뉴스 이미지 조회 성공"),
            @ApiResponse(responseCode = "404", description = "네이버 뉴스 이미지 조회 실패")
    })
    @GetMapping("/naverNews/image/{keyword}")
    public List<String> getImageUrl(@PathVariable String keyword) {
        return newsGetService.getImageUrl(keyword);
    }
}
