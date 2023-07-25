package com.project.movie.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.movie.domain.MovieDetailReplyCntFavDTO;
import com.project.movie.domain.MovieDetailReplyDTO;
import com.project.movie.domain.WishlistDTO;
import com.project.movie.response.KmdbRes;
import com.project.movie.response.TotalRes;
import com.project.movie.service.DetailReplyService;
import com.project.movie.service.MovieDetailService;
import com.project.movie.service.MovieService;
import com.project.movie.service.WishlistService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
		
	@Autowired
	private MovieDetailService movieDetailService;
	@Autowired
	private MovieService movieService;	
	@Autowired
	private DetailReplyService detailReplyService;
	
	@Autowired
	private WishlistService wishlistService;
	
	@GetMapping("/")
	public String main(Model model) {
		log.info("index 폼 요청");
		List<MovieDetailReplyDTO> rankGradeDtoList = movieService.rankGrade();		
				
		//for문 title 추출한 후 
		for (MovieDetailReplyDTO movieDetailReplyDTO : rankGradeDtoList) {			
			movieDetailReplyDTO.setPosterUrl(movieService.rankGrade(movieDetailReplyDTO.getTitle()));			
		}
		//System.out.println("rankGradeDtoList"+rankGradeDtoList);
		model.addAttribute("rankGradeDtoList", rankGradeDtoList);				
		return "index";
	}
	
	@GetMapping("/movie/details")
	  public String movieDetails(Model model, String movieNm, String movieDt) {
		log.info("박스오피스 상세페이지 폼 요청");
		//String userid = principal.getName();


		TotalRes kres = movieService.movie();
		//System.out.println("상세 폼 "+kres);
		String rOpenDt = movieDt.replaceAll("-", "");
		//System.out.println("개봉일 확인 "+rOpenDt);
		KmdbRes res = movieDetailService.getDetails(movieNm, rOpenDt);	

		//System.out.println("확인 "+res);
		
		res.setGrade(detailReplyService.avgGrade(movieNm));		
		
		model.addAttribute("detail", res);
		model.addAttribute("list",kres.getList());

		//model.addAttribute("userid", userid);
		// 상세페이지 포스터 댓글 수 불러오기
		MovieDetailReplyCntFavDTO dto=detailReplyService.getList(movieNm);
		model.addAttribute("count", dto.getReplyCnt());		
		
		// 상세페이지 포스터 평점 불러오기
		model.addAttribute("avg", detailReplyService.avgGrade(movieNm));

		return "/movie/movie-details";

	}


	@GetMapping("/search")
	public String searchList(String query, Model model){
		log.info("영화 검색 ");
		model.addAttribute("list",movieService.search(query));
		model.addAttribute("query",query);
		return "/movie/search";
	}
	
	@GetMapping("/showWish")
	public String getWish() {
		log.info("위시리스트 조회");
		
		return "/movie/wishList";
	}


	@GetMapping("/auth")
	@ResponseBody
	public Authentication auth() {		
		return SecurityContextHolder.getContext().getAuthentication(); 
	}
	
}						
