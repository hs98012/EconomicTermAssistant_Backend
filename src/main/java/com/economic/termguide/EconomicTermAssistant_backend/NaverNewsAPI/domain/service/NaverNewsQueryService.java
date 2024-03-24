package com.economic.termguide.EconomicTermAssistant_backend.NaverNewsAPI.domain.service;

import com.economic.termguide.EconomicTermAssistant_backend.NaverNewsAPI.domain.config.NaverNewsConfig;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NaverNewsQueryService {

    private final NaverNewsConfig newsConfig;

    public String formatLink(String originalLink) {
        String link = originalLink.replace("\\/", "/");
        return link;
    }
    public String searchNews(String query) {
        String text;
        try {
            text = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패", e);
        }

        String apiURL = "https://openapi.naver.com/v1/search/news?query=" + text;
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", newsConfig.getClientId());
        requestHeaders.put("X-Naver-Client-Secret", newsConfig.getClientSecret());
        String json = get(apiURL, requestHeaders);
        json = formatLink(json);
        return json;
    }

    private String get(String apiUrl, Map<String, String> requestHeaders) {
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readBody(con.getInputStream());
            } else {
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            throw new RuntimeException("연결 실패: " + apiUrl, e);
        }
    }

    private String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
    //원문 이미지 url
    public List<String> getImageUrl(String keyword) {
        String news = searchNews(keyword);

        JSONObject data = new JSONObject(news);

        // 'items' 키에 해당하는 값을 가져옴
        JSONArray items = data.optJSONArray("items");

        // 'originallink' 값을 저장할 리스트 초기화
        List<String> originallinks = new ArrayList<>();

        if (items != null) {
            // 각 아이템을 순회하며 'originallink' 추출 후 리스트에 추가
            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                String originallink = item.optString("originallink");
                if (!originallink.isEmpty()) {  // originallink가 존재한다면
                    originallinks.add(originallink);
                }
            }
        }
        List<String> imageUrls = new ArrayList<>();
        for (int i = 0; i < originallinks.size(); i++) {
            String imageUrl = "";
            try {
                Document doc = Jsoup.connect(originallinks.get(i)).get();
                Element ogImage = doc.select("meta[property=og:image]").first();
                if (ogImage != null) {
                    imageUrl = ogImage.attr("content");
                    if (!imageUrl.startsWith("https:")) {
                        imageUrl = "https://" + imageUrl;
                    }
                    System.out.println(imageUrl);

                } else {
                    System.out.println("썸네일 이미지를 찾을 수 없습니다.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            imageUrls.add(imageUrl);
        }
        return imageUrls;
    }
}
