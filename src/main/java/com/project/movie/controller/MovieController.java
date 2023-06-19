package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.movie.response.BoxOfficeResponse.Movie;
import com.project.movie.response.TmdbSearchResponse;
import com.project.movie.response.TmdbSearchResponse.TmdbMovieResult;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final RestTemplate restTemplate;

    @Autowired
    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{koficMovieTitle}")
    public Movie getMovieDetails(@PathVariable String koficMovieTitle) {
        // TMDB API 키
        String tmdbApiKey = "6461fff89d9af7c612e73b1e1146ff50";
        // TMDB API에서 영화 검색 요청 보내기
        String searchUrl = "https://api.themoviedb.org/3/search/movie?api_key=" + tmdbApiKey + "&query=" + koficMovieTitle;
        TmdbSearchResponse searchResponse = restTemplate.getForObject(searchUrl, TmdbSearchResponse.class);

        if (searchResponse != null && searchResponse.getResults() != null) {
            // 검색 결과에서 영화와 일치하는 항목 찾기
            for (TmdbMovieResult result : searchResponse.getResults()) {
                if ("en".equals(result.getOriginal_language()) && koficMovieTitle.equals(result.getTitle())) {
                    // 영화의 movie_id 가져오기
                    Long movieId = Long.parseLong(result.getId());
                    // 언어 설정 (영화 상세 정보를 얻기 위해 필요)
                    String language = "ko"; // 한국어로 설정
                    // 영화 상세 정보 가져오기
                    return getMovieDetailsById(movieId, tmdbApiKey, language);
                }
            }
        }

        return null;
    }

    private Movie getMovieDetailsById(Long movieId, String tmdbApiKey, String language) {
        // TMDB API에서 영화 상세 정보 요청 보내기
        String movieUrl = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + tmdbApiKey + "&language=" + language;
        return restTemplate.getForObject(movieUrl, Movie.class);
    }
}
