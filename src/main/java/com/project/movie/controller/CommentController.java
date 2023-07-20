package com.project.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.domain.BlogCommentDTO;
import com.project.movie.service.BoardService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    
	@Autowired
    private BoardService commentService;
    
    public CommentController(BoardService commentService) {
        this.commentService = commentService;
    }
    
    @GetMapping("/{bno}")
    public ResponseEntity<List<BlogCommentDTO>> getCommentsByBoard(@PathVariable int bno) {
        List<BlogCommentDTO> comments = commentService.getCommentsByBoard(bno);
        return ResponseEntity.ok(comments);
    }
    
    
}

