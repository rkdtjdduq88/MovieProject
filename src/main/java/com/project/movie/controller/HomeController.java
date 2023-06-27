package com.project.movie.controller;
	



import com.project.movie.service.BoardService;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
	@Slf4j
	@Controller
	public class HomeController {
		
		@Autowired
		private BoardService boardService;
	
	    @GetMapping("/")
	    public String getMainPage(Model model) {
	        
	        return "main";
	    }
	}
