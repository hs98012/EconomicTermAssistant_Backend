package com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.application.service;

import com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.domain.service.NewsQueryService;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Transactional
public class NewsGetService {

    private final NewsQueryService newsQueryService;
    public CompletableFuture<List<Map<String, String>>> getNewsByKeyword(String keyword) {
        CompletableFuture<List<Map<String, String>>> newsByKeyword = newsQueryService.getNewsByKeyword(keyword);
        return newsByKeyword;
    }
}

