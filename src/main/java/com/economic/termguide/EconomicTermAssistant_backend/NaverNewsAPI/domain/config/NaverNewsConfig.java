package com.economic.termguide.EconomicTermAssistant_backend.NaverNewsAPI.domain.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NaverNewsConfig {

    @Value("${x-naver.client.id}")
    private String clientId;

    @Value("${x-naver.client.secret}")
    private String clientSecret;


}
