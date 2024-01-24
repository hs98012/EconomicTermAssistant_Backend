package com.economic.termguide.EconomicTermAssistant_backend.Article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArticleResponse {

    @JsonProperty("articles")
    private List<Article> articles;

}
