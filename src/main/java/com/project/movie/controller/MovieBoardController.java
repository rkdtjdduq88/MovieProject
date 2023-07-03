package com.project.movie.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.movie.dto.AttachFileDTO;
import com.project.movie.dto.BlogCommentDTO;
import com.project.movie.dto.Criteria;
import com.project.movie.dto.MovieBoardDTO;
import com.project.movie.dto.PageDTO;
import com.project.movie.service.BoardService;
import com.project.movie.service.MovieBoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MovieBoardController {
	
	@Autowired
	private MovieBoardService service;
	@Autowired
	private BoardService boardservice;
	@GetMapping("/main-board")
    public void MainBoard(Model model, @ModelAttribute("cri") Criteria cri, HttpSession session) {
    	log.info("게시판 폼 요청");
    	
    	// 1. 총 게시물 수
    	int totalPosts=service.getTotalCnt(cri);
    	model.addAttribute("totalPosts", totalPosts);
	}
	
	// 전체 리스트 보여주기 컨트롤러 작성: list.jsp 보여주기
	@GetMapping("/list")
	public void getList(Model model, @ModelAttribute("cri") Criteria cri) {
		log.info("list request");
		
		List<MovieBoardDTO> list=service.getList(cri); // 사용자가 요청한 번호에 맞는 게시물 목록 요청
		int total=service.getTotalCnt(cri); // 전체 게시물 개수
	     // Retrieve the comments associated with the blog post
        

		model.addAttribute("list", list); // 목록 정보 넘기기
		model.addAttribute("pageDTO", new PageDTO(cri, total)); // 페이지 관련 정보 넘기기
	}
	
	// register.jsp 보여주기
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public void registerForm(Model model) {
		// 사용자 정보 가져오기
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    model.addAttribute("username", username);
		log.info("register form request");
	}
	
	@PostMapping("/register")
	public String register(MovieBoardDTO boardDTO, RedirectAttributes rttr, Criteria cri) {
	    log.info("register request " + boardDTO);
	    
	    // 첨부파일 확인
	    if (boardDTO.getAttachList() != null) {
	        boardDTO.getAttachList().forEach(attach -> {
	            log.info(attach.toString());
	            // 첨부파일의 이름을 가져와서 attach 열에 저장
	            String attachFileName = attach.getUuid() + "_" + attach.getFileName();
	            // attach 열에 저장된 이미지 파일 이름 설정
	            boardDTO.setAttach(attachFileName);
	        });
	    }
	    
	    boolean insertFlag = service.register(boardDTO);
	    if (insertFlag) {
	        log.info("글 번호: " + boardDTO.getBno());
	        rttr.addFlashAttribute("result", boardDTO.getBno());
	        
	        rttr.addAttribute("page", cri.getPage());
	        rttr.addAttribute("amount", cri.getAmount());
	        
	        return "redirect:/list";
	    }
	    return "/register";
	}

	// http://localhost:8080/board/read??page=1&amount=10&bno=917
	// http://localhost:8080/board/modify??page=1&amount=10&bno=917
	@GetMapping({"/read", "/modify"})
	public void readGet(int bno, Model model, @ModelAttribute("cri") Criteria cri) {
		log.info("read request "+bno);
		List<BlogCommentDTO> comments = boardservice.getCommentsByBoard(bno);
        // Add the comments to the model with the attribute name "comments"
        model.addAttribute("comments", comments);
		// bno에 해당하는 내용 가져오기
		MovieBoardDTO dto=service.read(bno);
		model.addAttribute("dto", dto);
	}
	
//	@GetMapping({"/read", "/modify"})
//	@ResponseBody
//	public ResponseEntity<?> readGet(int bno, Model model, @ModelAttribute("cri") Criteria cri) {
//	    log.info("read request " + bno);
//	    List<BlogCommentDTO> comments = boardservice.getCommentsByBoard(bno);
//	    // Add the comments to the model with the attribute name "comments"
//	    model.addAttribute("comments", comments);
//	    // bno에 해당하는 내용 가져오기
//	    MovieBoardDTO dto = service.read(bno);
//	    model.addAttribute("dto", dto);
//	    
//	    // 데이터를 JSON 형식으로 반환
//	    return ResponseEntity.ok(model.asMap());
//	}

	
	@PostMapping("/modify")
	public String modifyPost(MovieBoardDTO boardDTO, RedirectAttributes rttr, Criteria cri) {
		log.info("modify request"+cri); 
		// 수정 성공 시 리스트로 가기
		service.modify(boardDTO);
		rttr.addFlashAttribute("result", "success");
		
		// 페이지 나누기 정보 주소줄에 같이 보내기
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("amount", cri.getAmount());
		
		// 수정 버튼 눌렀을 때 검색 정보 주소줄에 보내기
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/list";
	}
	
	@GetMapping("/remove")
	@PreAuthorize("principal.username == #userid") // 로그인 사용자 == 작성자
	public String removeGet(int bno, String userid, RedirectAttributes rttr, Criteria cri) {

		// 폴더에서 첨부파일 제거
		List<AttachFileDTO> attachList = service.getAttachList(bno);
		deleteAttachFiles(attachList);
		
		// 삭제 성공 시 리스트로 가기
		service.remove(bno);
		
		rttr.addFlashAttribute("result", "success");
		
		// 페이지 나누기 정보 주소줄에 같이 보내기
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("amount", cri.getAmount());
		
		// 삭제 버튼 눌렀을 때 검색 정보 주소줄에 보내기
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/list";
	}
	
	// 첨부 파일 가져오기(/getAttachList) + GET + bno
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileDTO>> attachList(int bno){
		List<AttachFileDTO> attachList=service.getAttachList(bno);
		
		return attachList != null ? new ResponseEntity<List<AttachFileDTO>>(attachList, HttpStatus.OK):
			new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	private void deleteAttachFiles(List<AttachFileDTO> attachList) {
		log.info("첨부 파일 폴더에서 제거");
		
		if(attachList == null || attachList.size() <= 0) return;
		
		for(AttachFileDTO dto : attachList) {
			// 파일 경로
			Path path=Paths.get("c:\\upload\\"+dto.getUploadPath()+"\\"+dto.getUuid()+"_"+dto.getFileName());
			
			try {
				Files.deleteIfExists(path);
				
				// 이미지 파일인 경우 썸네일 제거
				if(Files.probeContentType(path).startsWith("image")) {
					Path thumb=Paths.get("c:\\upload\\"+dto.getUploadPath()+"\\s_"+dto.getUuid()+"_"+dto.getFileName());
					Files.deleteIfExists(thumb);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}