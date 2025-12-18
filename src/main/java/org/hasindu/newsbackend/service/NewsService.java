package org.hasindu.newsbackend.service;

import org.hasindu.newsbackend.dto.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NewsService {

    private final RestClient restClient;
    private final String apiKey;

    public NewsService(@Value("${news.api.url}") String baseUrl,
                       @Value("${news.api.key}") String apiKey) {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);  // Wait 5s to connect
        factory.setReadTimeout(30000);    // Wait 30s for data to arrive

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(factory)
                .build();

        this.apiKey = apiKey;
    }

    public NewsResponse getTopHeadlines() {
        return getNews("all");
    }

    // category
    public NewsResponse getNews(String category) {
        return restClient.get()
                .uri(uriBuilder -> {
                    uriBuilder
                            .path("/top")
                            .queryParam("api_token", apiKey)
                            .queryParam("locale", "us")
                            .queryParam("limit", "6");

                    // Only add category if it's not "all" or null
                    if (category != null && !category.equals("all")) {
                        uriBuilder.queryParam("categories", category);
                    }

                    return uriBuilder.build();
                })
                .retrieve()
                .body(NewsResponse.class);
    }

    // search
    public NewsResponse getNews(String category, String search) {
        return restClient.get()
                .uri(uriBuilder -> {
                    uriBuilder
                            .path("/top")
                            .queryParam("api_token", apiKey)
                            .queryParam("locale", "us")
                            .queryParam("limit", "6");

                    // Add Category filter
                    if (category != null && !category.equals("all")) {
                        uriBuilder.queryParam("categories", category);
                    }

                    // Add Search filter (NEW)
                    if (search != null && !search.isEmpty()) {
                        uriBuilder.queryParam("search", search);
                    }

                    return uriBuilder.build();
                })
                .retrieve()
                .body(NewsResponse.class);
    }

    public NewsResponse getNews(String category, String search, int page) {
        return restClient.get()
                .uri(uriBuilder -> {
                    uriBuilder
                            .path("/top")
                            .queryParam("api_token", apiKey)
                            .queryParam("locale", "us")
                            .queryParam("limit", "6")
                            .queryParam("page", page);

                    if (category != null && !category.equals("all")) {
                        uriBuilder.queryParam("categories", category);
                    }
                    if (search != null && !search.isEmpty()) {
                        uriBuilder.queryParam("search", search);
                    }

                    return uriBuilder.build();
                })
                .retrieve()
                .body(NewsResponse.class);
    }
}