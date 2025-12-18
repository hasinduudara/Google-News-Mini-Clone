package org.hasindu.newsbackend.controller;

import org.hasindu.newsbackend.dto.NewsResponse;
import org.hasindu.newsbackend.service.NewsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "http://localhost:5173") // Allow React (Vite) to access this
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/top")
    public NewsResponse getTopNews() {
        return newsService.getTopHeadlines();
    }
}