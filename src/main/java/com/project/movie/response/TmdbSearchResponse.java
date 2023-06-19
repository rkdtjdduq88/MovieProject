package com.project.movie.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List; // Add this import statement

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TmdbSearchResponse {
    private List<TmdbMovieResult> results;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TmdbMovieResult {
        private String id;
        private String title;
        private String release_date;
        private String poster_path;
        private String original_language;
    }
}
