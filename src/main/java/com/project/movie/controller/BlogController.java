package com.project.movie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movie.dto.BlogCommentDTO;
import com.project.movie.dto.BoardDTO;
import com.project.movie.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BlogController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/blog")
    public String blog(@RequestParam(defaultValue = "1") int page, Model model) {
        int recordSize = 6; // 페이지당 출력할 데이터 개수

        int totalCount = boardService.getBlogCount(); // 전체 게시글 수 가져오기
        int totalPages = (int) Math.ceil((double) totalCount / recordSize); // 전체 페이지 수 계산

        int offset = (page - 1) * recordSize; // 데이터 조회 시작 위치

        List<BoardDTO> boardList = boardService.getBoardListByPage(offset, recordSize); // 페이징된 게시물 목록 가져오기

        model.addAttribute("boardList", boardList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "blog";
    }

    @GetMapping("/blog-details/{bno}")
    public String getBlogDetails(@PathVariable int bno, Model model) {
        BoardDTO boardDetail = boardService.getBlogDetails(bno);
        model.addAttribute("boardDto", boardDetail);

        List<BlogCommentDTO> comments = boardService.getCommentsByBoard(bno);
        model.addAttribute("comments", comments);

        // 대댓글 조회
        for (BlogCommentDTO comment : comments) {
            List<BlogCommentDTO> replies = boardService.getRepliesByComment(comment.getRno());
            comment.setReplies(replies);
        }

        return "blog-details";
    }


    @PostMapping("/blog-details/{bno}/comment")
    public String addComment(@PathVariable int bno, @ModelAttribute BlogCommentDTO comment, HttpSession session) {
        comment.setBno(bno); // 댓글의 게시물 번호 설정
        String currentUserId = (String) session.getAttribute("userid");
        if (currentUserId != null) {
            comment.setUserid(currentUserId);
        } else {
            // 로그인하지 않은 사용자의 경우 처리 방법을 지정 (예: 익명 사용자로 설정)
            comment.setUserid("anonymousUser");
        }

        boardService.insertComment(comment);
        log.info("댓글 입력 요청: " + bno + ", " + comment);
        return "redirect:/blog-details/" + bno;
    }
    @PostMapping("/blog-details/{bno}/reply")
    public String addReply(@PathVariable int bno, @ModelAttribute BlogCommentDTO reply, HttpSession session) {
        reply.setBno(bno); // 대댓글의 게시물 번호 설정
        String currentUserId = (String) session.getAttribute("userid");
        if (currentUserId != null) {
            reply.setUserid(currentUserId);
        } else {
            // 로그인하지 않은 사용자의 경우 처리 방법을 지정 (예: 익명 사용자로 설정)
            reply.setUserid("anonymousUser");
        }

        boardService.insertReply(reply);
        log.info("대댓글 입력 요청: " + bno + ", " + reply);
        return "redirect:/blog-details/" + bno;
    }

}
