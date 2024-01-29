package com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.presentation;

import com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.application.service.NewsGetService;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsGetService newsGetService;

    @Operation(summary = "뉴스 키워드 조회", tags = {"NewsController"})
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "뉴스 키워드 조회 성공"),
        @ApiResponse(responseCode = "404", description = "뉴스 키워드 조회 실패")
    })
    @GetMapping("/news/{keyword}")
    public CompletableFuture<ResponseEntity<List<Map<String, String>>>> getNewsByKeyword(@PathVariable String keyword) {
        return newsGetService.getNewsByKeyword(keyword)
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> ResponseEntity.status(500).build());
        }
}
