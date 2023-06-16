package com.project.movie.controller;


import com.project.movie.response.BoxOfficeResponse.Movie;
import com.project.movie.service.BoxOfficeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BoxOfficeController {

    private static final String API_KEY = "7083241ea008894c70a0978fe6fbc95c";

    @Autowired
    private BoxOfficeService boxOfficeService; // BoxOfficeService 주입

    @GetMapping("/api/boxoffice/{date}")
    public ResponseEntity<List<Movie>> getDailyBoxOffice(@PathVariable("date") String date,
                                                         @RequestParam(value = "itemPerPage", defaultValue = "10") int itemPerPage,
                                                         @RequestParam(value = "multiMovieYn", defaultValue = "") String multiMovieYn,
                                                         @RequestParam(value = "repNationCd", defaultValue = "") String repNationCd,
                                                         @RequestParam(value = "wideAreaCd", defaultValue = "") String wideAreaCd) {
        List<Movie> movies = boxOfficeService.getDailyBoxOfficeMovies(date, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);
        if (movies != null && !movies.isEmpty()) {
            return ResponseEntity.ok(movies);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
