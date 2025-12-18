package org.hasindu.newsbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Article {
    private String uuid;
    private String title;
    private String description;
    private String snippet;
    private String url;

    @JsonProperty("image_url") // Maps JSON 'image_url' to Java 'imageUrl'
    private String imageUrl;

    @JsonProperty("published_at")
    private String publishedAt;

    private String source;
    private List<String> categories;
}