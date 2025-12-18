package org.hasindu.newsbackend.controller;

import org.hasindu.newsbackend.dto.NewsResponse;
import org.hasindu.newsbackend.service.NewsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "http://localhost:5173")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public NewsResponse getNews(
            @RequestParam(defaultValue = "all") String category,
            @RequestParam(required = false) String search) {

        return newsService.getNews(category, search);
    }
}