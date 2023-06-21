package com.project.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String main() {


		return "main";

	}
	  @GetMapping("/blog")
	    public String goToBlog() {
	        log.info("블로그 페이지 요청");
	        return "blog";
	    }
	  @GetMapping("/blog-details")
	  public String goToBlogDetails() {
		  log.info("블로그 페이지 요청");
		  return "blog-details";
	  }
	  
	  @GetMapping("/movie-details")
	  public String goToMovieDetails() {
		  log.info("영화 상세 페이지 요청");
		  return "movie-details";
	  }

	  
	  
}
