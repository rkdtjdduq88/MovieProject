package com.project.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.response.KmdbAndKobisDTO;
import com.project.movie.response.KmdbRes;
import com.project.movie.response.TotalRes;
import com.project.movie.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api")
public class MovieApiController {
	
	@Autowired
	private MovieService movieService;
	
	@ResponseBody
	@GetMapping("/boxoffice")
	public TotalRes dailyBoxOfficeList() {
		log.info("검색 요청 ");		
		
		return movieService.movie();
	}
	
	@ResponseBody
	@GetMapping("/boxoffice/carousel")
	public TotalRes mainCarousel() {

		log.info("검색 요청 ");
		return movieService.movie();
	}	
	


}
