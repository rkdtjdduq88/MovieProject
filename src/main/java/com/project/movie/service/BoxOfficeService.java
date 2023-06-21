package com.project.movie.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.movie.response.BoxOfficeResponse.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoxOfficeService {

    @Value("${tmdb.api.key}")
    private String tmdbApiKey;

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    public BoxOfficeService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Movie> getPopularMovies() {
        String tmdbApiUrl = "https://api.themoviedb.org/3/movie/popular?api_key=" + tmdbApiKey;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(tmdbApiUrl, String.class);
        String response = responseEntity.getBody();

        List<Movie> movieList = new ArrayList<>();

        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            JsonNode resultsNode = jsonNode.get("results");

            for (JsonNode movieNode : resultsNode) {
                String title = movieNode.get("title").asText();
                String posterPath = movieNode.get("poster_path").asText();
                double rating = movieNode.get("vote_average").asDouble();
                
                String posterUrl = "https://image.tmdb.org/t/p/w500" + posterPath;
                String koreanTitle = getKoreanTitleFromTmdb(title);
                Movie movie = new Movie(title, posterUrl, rating, koreanTitle);
              
                movieList.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieList;
    }

    public List<Movie> getMoviesWithKoreanTitle(List<Movie> movies) {
        for (Movie movie : movies) {
            String koreanTitle = getKoreanTitleFromTmdb(movie.getTitle());
            movie.setKoreanTitle(koreanTitle);
        }
        return movies;
    }

    private String getKoreanTitleFromTmdb(String englishTitle) {
        String tmdbApiUrl = "https://api.themoviedb.org/3/search/movie?api_key=" + tmdbApiKey + "&language=ko-KR&query="
                + englishTitle;

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(tmdbApiUrl, String.class);
        String response = responseEntity.getBody();

        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            JsonNode resultsNode = jsonNode.get("results");

            if (resultsNode.isArray() && resultsNode.size() > 0) {
                JsonNode movieNode = resultsNode.get(0);
                String koreanTitle = movieNode.get("title").asText();
                return koreanTitle;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ""; // Return an empty string if the Korean title cannot be retrieved
    }
}
