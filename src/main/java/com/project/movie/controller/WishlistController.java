package com.project.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.domain.MovieDetailReplyDTO;
import com.project.movie.domain.WishlistDTO;
import com.project.movie.service.WishlistService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/wish")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	// insert 작업 + 중복 확인해야함
	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody WishlistDTO wishlistDTO, Model model){
		log.info("위시리스트 추가 "+wishlistDTO);
		
		if (wishlistService.dupCheck(wishlistDTO.getUserid(), wishlistDTO.getTitle())) {
	        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
	    }

	    //model.addAttribute("dto", wishlistDTO);
	    wishlistService.insert(wishlistDTO);
	    
	    return new ResponseEntity<String>("위시리스트에 추가되었습니다.", HttpStatus.OK);
		
//		model.addAttribute("dto", wishlistDTO);
//		return wishlistService.insert(wishlistDTO)?
//				new ResponseEntity<String>("success", HttpStatus.OK):
//					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	    
	
	// 위시리스트 전체 조회
	@GetMapping("/wishList/{userid}")
	public List<WishlistDTO> wishAll(@PathVariable("userid") String userid){
		log.info("사용자의 위시리스트 조회 ");
		
		return wishlistService.getList(userid);
	}
	
	// 위시리스트 제거
	@DeleteMapping("/remove/{wno}")
	public ResponseEntity<String> remove(@PathVariable("wno") int wno){
		log.info("위시리스트에서 삭제 ");
		
		return wishlistService.delete(wno)?
				new ResponseEntity<String>("위시리스트에서 제거 완료", HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
		
	
	
}
