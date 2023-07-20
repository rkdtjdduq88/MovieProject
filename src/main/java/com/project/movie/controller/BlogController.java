package com.project.movie.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.movie.domain.AttachFileDTO;
import com.project.movie.domain.BlogCommentDTO;
import com.project.movie.domain.BoardDTO;
import com.project.movie.domain.MovieBoardDTO;
import com.project.movie.service.BoardService;
import com.project.movie.service.MovieBoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BlogController {

    @Autowired
    private BoardService boardService;
    
    @Autowired
    private MovieBoardService movieBoardService;
    @GetMapping("/blog")
    public String blog(@RequestParam(defaultValue = "1") int page, Model model) {
        int recordSize = 6; // 페이지당 출력할 데이터 개수
        
        int totalCount = boardService.getBlogCount(); // 전체 게시글 수 가져오기
        int totalPages = (int) Math.ceil((double) totalCount / recordSize); // 전체 페이지 수 계산

        int offset = (page - 1) * recordSize; // 데이터 조회 시작 위치
        
        
        
        List<BoardDTO> boardList = boardService.getBoardListByPage(offset, recordSize); // 페이징된 게시물 목록 가져오기
        
        // Retrieve the attach file list for each board
        for (BoardDTO board : boardList) {
            int bno = board.getBno();
            List<AttachFileDTO> attachList = movieBoardService.getAttachList(bno);
            board.setAttachList(attachList);
        }
        model.addAttribute("boardList", boardList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
     


        return "blog";
    }

    @GetMapping("/blog-details/{bno}")
    public String getBlogDetails(@PathVariable int bno, Model model, HttpSession session) {
        // 지정된 bno를 가진 블로그 포스트의 세부 정보를 가져옵니다
        BoardDTO boardDetail = boardService.getBlogDetails(bno);
        // boardDetail을 "boardDto"라는 속성 이름으로 모델에 추가합니다
        model.addAttribute("boardDto", boardDetail);

        // 블로그 포스트와 관련된 댓글을 가져옵니다
        List<BlogCommentDTO> comments = boardService.getCommentsByBoard(bno);
        // comments를 "comments"라는 속성 이름으로 모델에 추가합니다
        model.addAttribute("comments", comments);

        // 세션에서 로그인된 사용자를 가져옵니다
        String loggedInUser = (String) session.getAttribute("userid");
        // 로그인된 사용자를 "loggedInUser"라는 속성 이름으로 모델에 추가합니다
        model.addAttribute("loggedInUser", loggedInUser);

        // 이전 게시물 정보를 가져옵니다
        BoardDTO previousPost = boardService.getPreviousPost(bno);
        // 이전 게시물 정보를 모델에 추가합니다
        model.addAttribute("previousPost", previousPost);

        // 다음 게시물 정보를 가져옵니다
        BoardDTO nextPost = boardService.getNextPost(bno);
        // 다음 게시물 정보를 모델에 추가합니다
        model.addAttribute("nextPost", nextPost);
      
        // 뷰 이름 "blog-details"를 반환합니다
        return "blog-details";
    }





    @PostMapping("/blog-details/{bno}/comment")
    public String addComment(@PathVariable int bno, @ModelAttribute BlogCommentDTO comment, HttpSession session, Model model) {
        comment.setBno(bno); // Set the comment's post number

        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserId = authentication.getName();

        // Set the userid if it is not null, otherwise set it to "anonymousUser"
        comment.setUserid(currentUserId != null ? currentUserId : "anonymousUser");

        // Add the loggedInUser attribute to the model
        model.addAttribute("loggedInUser", comment.getUserid());

        // Insert the comment
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

    @PostMapping("/blog-details/{bno}/comment/{rno}/update")
    public ResponseEntity<String> updateComment(@PathVariable("rno") int rno, @RequestBody BlogCommentDTO comment) {
        BlogCommentDTO existingComment = boardService.getComment(rno);
        if (existingComment != null) {
            existingComment.setReplyContent(comment.getReplyContent());
            boardService.updateComment(existingComment);
            return ResponseEntity.ok("Comment updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/blog-details/{bno}/comment/{rno}/delete")
    public String deleteComment(@PathVariable("rno") int rno, RedirectAttributes redirectAttributes) {
        boardService.deleteComment(rno);
        redirectAttributes.addFlashAttribute("message", "Comment deleted successfully.");
        return "redirect:/blog-details/{bno}"; // Replace {bno} with the actual blog ID
    }
}