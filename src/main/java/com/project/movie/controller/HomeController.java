package com.project.movie.controller;
	


import com.project.movie.response.BoxOfficeResponse.Movie;
import com.project.movie.service.BoardService;
import com.project.movie.service.BoxOfficeService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
	@Slf4j
	@Controller
	public class HomeController {
		@Autowired
	    private BoxOfficeService boxOfficeService;
		@Autowired
		private BoardService boardService;
	
	    @GetMapping("/")
	    public String getMainPage(Model model) {
	        try {
	            List<Movie> movieRanking = boxOfficeService.getPopularMovies();
	            model.addAttribute("movieRanking", movieRanking);
	        } catch (RuntimeException e) {
	            e.printStackTrace();
	            model.addAttribute("errorMessage", "Failed to retrieve movie ranking");
	        }
	
	        return "main";
	    }
	}
