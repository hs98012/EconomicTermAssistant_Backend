package com.economic.termguide.EconomicTermAssistant_backend.NaverNewsAPI.application.service;

import com.economic.termguide.EconomicTermAssistant_backend.NaverNewsAPI.domain.service.NaverNewsQueryService;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class NaverNewsGetService {

    private final NaverNewsQueryService newsQueryService;

    public String getNewsByKeyword(String keyword) {
//        System.out.println(newsQueryService.searchNews(keyword));
        return newsQueryService.searchNews(keyword);
    }

    public List<String> getImageUrl(String keyword) {
        return newsQueryService.getImageUrl(keyword);
    }
}
