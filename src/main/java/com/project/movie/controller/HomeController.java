<<<<<<< HEAD
package com.project.movie.controller;

import java.net.URI;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
=======
	package com.project.movie.controller;
	
	import com.project.movie.response.BoxOfficeResponse.Movie;
	import com.project.movie.service.BoxOfficeService;
>>>>>>> branch 'kang' of https://github.com/rkdtjdduq88/MovieProject.git

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	
<<<<<<< HEAD
	@GetMapping("/")
	public String main() {
		log.info("main 폼 요청");

<<<<<<< HEAD
		return "index";					
	}	
}
=======
		return "boxoffice";
		
		//return "index";

=======
	import java.util.List;
	@Slf4j
	@Controller
	public class HomeController {
		@Autowired
	    private BoxOfficeService boxOfficeService;
	
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
	    @GetMapping("/blog")
	    public void goToBlog() {
	    	log.info("블로그 폼 요청");
	    	 
	    }
>>>>>>> refs/remotes/origin/seungoh
	}
>>>>>>> branch 'kang' of https://github.com/rkdtjdduq88/MovieProject.git
