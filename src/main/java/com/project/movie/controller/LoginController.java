package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.movie.domain.MemberDTO;
import com.project.movie.service.RegisterService;

@Controller
public class LoginController {

	@Autowired
	private RegisterService service;
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@GetMapping("/agree")
	public String AgreePage() {
		return "agree";
	}
	
	@GetMapping("/register")
	public String RegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> insertPost(MemberDTO dto) {
	    try {
	        boolean insertFlag = service.insert(dto);
	        if (insertFlag) {
	            return ResponseEntity.ok().body("{\"success\": true, \"message\": \"회원가입이 성공적으로 완료되었습니다.\"}");
	        } else {
	            return ResponseEntity.ok().body("{\"success\": false, \"message\": \"회원가입에 실패했습니다. 다시 시도해주세요.\"}");
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return ResponseEntity.ok().body("{\"success\": false, \"message\": \"회원가입에 실패했습니다. 다시 시도해주세요.\"}");
	    }
	}
}
