package com.economic.termguide.EconomicTermAssistant_backend.Article.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("urlToImage")
    private String urlToImage;

    @JsonProperty("content")
    private String content;
}
