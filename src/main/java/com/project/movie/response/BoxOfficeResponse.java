package com.project.movie.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxOfficeResponse {
    private List<Movie> results;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Movie {
        private String title;
        private String poster_path;
        private double vote_average; // 기존의 rating 필드를 vote_average로 변경
        private String koreanTitle; // Add the koreanTitle field

        public String getPosterPath() {
            return poster_path;
        }
    }
}
