package com.project.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.dto.MovieDetailReplyDTO;
import com.project.movie.service.DetailReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/replies")
public class DetailReplyController {
	
	@Autowired
	private DetailReplyService detailReplyService;
			
	@GetMapping(value="/list/{title}")
	public List<MovieDetailReplyDTO> detailReplyList(@PathVariable("title") String title) {
		log.info("리뷰 리스트 요청"+title);	
		
		return detailReplyService.getList(title);
	}
}
