package com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.domain.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsQueryService {

    private final NewsApiClient newsApiClient;

    public CompletableFuture<List<Map<String, String>>> getNewsByKeyword(String keyword) {
        CompletableFuture<List<Map<String, String>>> completableFuture = new CompletableFuture<>();
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(keyword)
                        .language("ko")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        List<Article> articles = response.getArticles();
                        if (!articles.isEmpty()) {  // 기사 리스트의 크기가 0이 아닌지 확인
                            if (articles.size() >5) {
                                articles = articles.stream().limit(5).collect(Collectors.toList());
                            }
                            List<Map<String, String>> result = articles.stream().map(article -> {
                                Map<String, String> map = new LinkedHashMap<>();
                                map.put("title", article.getTitle());
                                map.put("description", article.getDescription());
                                map.put("url", article.getUrl());
                                map.put("urlToImage", article.getUrlToImage());
                                return map;
                            }).collect(Collectors.toList());
                            completableFuture.complete(result);
                        } else {
                            System.out.println("No articles found");
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
    );
    return completableFuture;
}

}
