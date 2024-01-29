package com.economic.termguide.EconomicTermAssistant_backend.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "EconomicWord API",
                description = "EconomicWord API 문서입니다.",
                version = "v1"),
        servers = {
                @Server(url = "43.203.34.234", description = "운영서버"),
                @Server(url = "http://localhost:8080", description = "로컬서버")
        }

)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi economicWordOpenAPI() {
        String[] paths = {"/economicWord/**"};
        return GroupedOpenApi.builder()
                .group("EconomicWord API")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi BookmarkOpenAPI() {
        String[] paths = {"/bookmark/**"};
        return GroupedOpenApi.builder()
                .group("bookmark API")
                .pathsToMatch(paths)
                .build();
    }

    @Bean
    public GroupedOpenApi newsOpenAPI() {
        String[] paths = {"/news/**"};
        return GroupedOpenApi.builder()
                .group("News API")
                .pathsToMatch(paths)
                .build();
    }


}
