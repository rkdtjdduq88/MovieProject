package com.project.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
		
	@GetMapping("/")
	public String main() {
		log.info("index 폼 요청");
		return "index";
	}	
	
	@GetMapping("/movie/movie-details/")
	  public void movieDetails() {
		log.info("상세페이지 폼 요청");
//		  log.info("영화 상세 정보 이동 "+movieNm+openDt);
//		  log.info("영화 상세 정보 이동 ");
//		  String rOpenDt = openDt.replaceAll("-", "");
//		  System.out.println(rOpenDt);
//		  MovieDetailRes detail = getKmdbService.detailView(movieNm,rOpenDt);
		  
		  // detail 객체에 포스터 이미지 URL 정보 추가
//		    String posterUrl = detail.getPosterUrl(); // 포스터 이미지 URL 가져오기
//		    detail.setPosterUrl(posterUrl);
//		  
//		  model.addAttribute("detail", detail);		 
	  }
}
