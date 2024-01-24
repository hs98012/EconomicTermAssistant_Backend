package com.economic.termguide.EconomicTermAssistant_backend.NewsAPI.domain.config;

import com.kwabenaberko.newsapilib.NewsApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewsConfig {

    @Bean
    public NewsApiClient newsApiClient() {
        return new NewsApiClient("fbbd457a66e54535bc81188e05de6b94");
    }
}
