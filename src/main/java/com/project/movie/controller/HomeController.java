	package com.project.movie.controller;
	
	import com.project.movie.response.BoxOfficeResponse.Movie;
	import com.project.movie.service.BoxOfficeService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	
	import java.util.List;
	
	@Controller
	public class HomeController {
	
	    private final BoxOfficeService boxOfficeService;
	
	    @Autowired
	    public HomeController(BoxOfficeService boxOfficeService) {
	        this.boxOfficeService = boxOfficeService;
	    }
	
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
