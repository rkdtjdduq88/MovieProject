package com.project.movie.controller;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String main() {
        log.info("index 폼 요청");

//        try {
//            List<Movie> movieRanking = boxOfficeService.getPopularMovies();
//            model.addAttribute("movieRanking", movieRanking);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            model.addAttribute("errorMessage", "Failed to retrieve movie ranking");
//        }

        return "index";
    }
}
