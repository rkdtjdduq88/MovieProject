package com.project.movie.controller;

import com.project.movie.response.BoxOfficeResponse.Movie;
import com.project.movie.service.BoxOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MovieController {

    private final BoxOfficeService boxOfficeService;

    @Autowired
    public MovieController(BoxOfficeService boxOfficeService) {
        this.boxOfficeService = boxOfficeService;
    }

    @GetMapping("/popularMovies")
    public ResponseEntity<List<Movie>> getPopularMovies() {
        try {
            List<Movie> movieRanking = boxOfficeService.getPopularMovies();
            List<Movie> moviesWithKoreanTitle = boxOfficeService.getMoviesWithKoreanTitle(movieRanking);
            return new ResponseEntity<>(moviesWithKoreanTitle, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
