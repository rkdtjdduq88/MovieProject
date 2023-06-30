package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movie.domain.AuthDTO;
import com.project.movie.domain.LoginDTO;
import com.project.movie.domain.MemberDTO;
import com.project.movie.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {
	

	@Autowired
	private RegisterService service;
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loggedIn", false); // 로그인 상태를 false로 설정
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
	public String login(@RequestParam("userid") String userId, @RequestParam("password") String password, HttpSession session, Model model) {
		 
		MemberDTO member = service.login(userId);

         if (member != null && passwordEncoder.matches(password, member.getPassword())) {
             // 로그인 성공
             session.setAttribute("userid", userId); // 세션에 userid 저장
             model.addAttribute("loggedIn", true); // 로그인 상태를 true로 설정
             return "redirect:/";
         } else {
             // 로그인 실패
             model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
             model.addAttribute("loggedIn", false); // 로그인 상태를 false로 설정
             return "login";
         }
	}

}


