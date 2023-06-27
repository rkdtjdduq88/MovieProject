package com.project.movie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.domain.MovieDetailReplyDTO;
import com.project.movie.service.DetailReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/replies")
public class DetailReplyController {
	
	@Autowired
	private DetailReplyService detailReplyService;
			
	@GetMapping("/list/{title}")
	public List<MovieDetailReplyDTO> detailReplyList(@PathVariable("title") String title) {
		log.info("리뷰 리스트 요청"+title);	
		
		
		return detailReplyService.getList(title);
	}
	
	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody MovieDetailReplyDTO movieDetailReplyDTO,Model model){
		log.info("댓글 삽입 "+movieDetailReplyDTO);
		
		model.addAttribute("dto", movieDetailReplyDTO);
		return detailReplyService.insert(movieDetailReplyDTO)?
				new ResponseEntity<String>("success", HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PostMapping("/modify")
	public ResponseEntity<String> modify(@RequestBody MovieDetailReplyDTO movieDetailReplyDTO){
		log.info("댓글 수정 "+movieDetailReplyDTO);
		
		return detailReplyService.update(movieDetailReplyDTO)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
