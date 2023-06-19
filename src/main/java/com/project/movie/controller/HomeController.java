package com.project.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String main() {
		log.info("main 폼 요청");

		return "boxoffice";
		
		//return "index";

	}
}
