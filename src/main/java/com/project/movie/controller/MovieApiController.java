package com.project.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.mapper.MovieDetailReplyMapper;
import com.project.movie.response.KmdbAndKobisDTO;
import com.project.movie.response.KmdbRes;
import com.project.movie.response.TotalRes;
import com.project.movie.service.DetailReplyService;
import com.project.movie.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/boxoffice")
public class MovieApiController {
	
	@Autowired
	private MovieService movieService;	
	
	@Autowired
	private MovieDetailReplyMapper movieDetailReplyMapper;
	
	
	@GetMapping("")
	public TotalRes dailyBoxOfficeList() {
		log.info("검색 요청 ");				
		//kmdb, kobis 작업
		TotalRes res = movieService.movie();		
		//영화별 reply 구하기
		for(KmdbAndKobisDTO dto:res.getList()) {
			// 구해온 영화이름들을 다시 replyCnt 에 개수 담기			
			int replyCnt = movieDetailReplyMapper.getCountByTitle(dto.getMovieNm());
			int avgGrade = movieDetailReplyMapper.avgGrade(dto.getMovieNm());
			dto.setReplyCnt(replyCnt);
			dto.setAvgGrade(avgGrade);
		}		
		return res;
	}
	

	@GetMapping("/carousel")
	public List<KmdbRes> mainCarousel() {		
		log.info("검색 요청 ");
		
		return movieService.carouselMovie();
	}	
	
}