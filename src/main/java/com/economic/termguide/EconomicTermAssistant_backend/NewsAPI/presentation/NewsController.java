package com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.presentation;

import com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.application.service.NewsGetService;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
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
    @GetMapping("/news/{keyword}")
    public CompletableFuture<ResponseEntity<List<Map<String, String>>>> getNewsByKeyword(@PathVariable String keyword) {
        return newsGetService.getNewsByKeyword(keyword)
                .thenApply(ResponseEntity::ok)
                .exceptionally(e -> ResponseEntity.status(500).build());
        }
}
