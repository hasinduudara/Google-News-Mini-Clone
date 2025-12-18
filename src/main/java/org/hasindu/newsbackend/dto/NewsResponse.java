package org.hasindu.newsbackend.dto;

import lombok.Data;
import java.util.List;

@Data
public class NewsResponse {
    private Meta meta;
    private List<Article> data;

    @Data
    public static class Meta {
        private int found;
        private int returned;
        private int limit;
        private int page;
    }
}