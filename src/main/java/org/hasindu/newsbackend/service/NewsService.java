package org.hasindu.newsbackend.service;

import org.hasindu.newsbackend.dto.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NewsService {

    private final RestClient restClient;
    private final String apiKey;

    // Constructor injection
    public NewsService(RestClient.Builder builder,
                       @Value("${news.api.url}") String baseUrl,
                       @Value("${news.api.key}") String apiKey) {
        this.restClient = builder.baseUrl(baseUrl).build();
        this.apiKey = apiKey;
    }

    public NewsResponse getTopHeadlines() {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/top")
                        .queryParam("api_token", apiKey)
                        .queryParam("locale", "us")
                        .queryParam("limit", "5")
                        .build())
                .retrieve()
                .body(NewsResponse.class);
    }
}