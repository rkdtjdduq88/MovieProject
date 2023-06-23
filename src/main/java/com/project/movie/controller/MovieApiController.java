package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.response.KmdbAndKobisDTO;
import com.project.movie.response.TotalRes;
import com.project.movie.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/boxoffice")
public class MovieApiController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{date}")
	public TotalRes dailyBoxOfficeList(@PathVariable("date") String targetDt) {
		log.info("검색 요청 "+targetDt);		
		
		return movieService.movie(targetDt);
	}
	
	@GetMapping("/carousel/{date}")
	public TotalRes mainCarousel(@PathVariable("date") String targetDt) {

		log.info("검색 요청 "+targetDt);
		return movieService.movie(targetDt);
	}
	
}
