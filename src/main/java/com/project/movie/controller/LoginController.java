package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.movie.domain.AuthDTO;
import com.project.movie.domain.LoginDTO;
import com.project.movie.domain.MemberDTO;
import com.project.movie.service.RegisterService;
import javax.servlet.http.HttpSession;

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
	
	@PostMapping("/login")
	public ResponseEntity<?> loginPost(@ModelAttribute("loginDTO") LoginDTO loginDTO, HttpSession session) {
	    try {
	        AuthDTO authDTO = service.login(loginDTO);

	        if (authDTO != null) {
	            // 로그인 성공
	            session.setAttribute("authDTO", authDTO);
	            return ResponseEntity.ok().build(); // 성공 응답 반환
	        } else {
	            // 로그인 실패
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 올바르지 않습니다."); // 실패 응답 반환
	        }
	    } catch (Exception e) {
	        // 예외 발생 시
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요."); // 오류 응답 반환
	    }
	}
}