package com.project.movie.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.movie.dto.BoardDTO;
import com.project.movie.service.BoardService;

import lombok.extern.slf4j.Slf4j;
//import oracle.jdbc.proxy.annotation.Post;

@Controller
@Slf4j

public class BolgController {
	@Autowired
	public BoardService boardService;


    @GetMapping("/blog")
    public void blog(Model model) {
        log.info("블로그폼 요청");
            List<BoardDTO> boardList = boardService.getBoardList();
            System.out.println(boardList); // boardList 내용 출력
            model.addAttribute("boardList", boardList);
        }
    }

