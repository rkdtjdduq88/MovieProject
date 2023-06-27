package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.movie.domain.MemberDTO;
import com.project.movie.mapper.RegisterMapper;
import com.project.movie.service.RegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

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
	
//	@PostMapping("/login")
//	public ResponseEntity<?> loginPost(@ModelAttribute("loginDTO") LoginDTO loginDTO, HttpSession session) {
//	    try {
//	        AuthDTO authDTO = service.login(loginDTO);
//
//	        if (authDTO != null) {
//	            // 로그인 성공
//	            session.setAttribute("authDTO", authDTO);
//	            return ResponseEntity.ok().build(); // 성공 응답 반환
//	        } else {
//	            // 로그인 실패
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 올바르지 않습니다."); // 실패 응답 반환
//	        }
//	    } catch (Exception e) {
//	        // 예외 발생 시
//	        e.printStackTrace();
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요."); // 오류 응답 반환
//	    }
//	}
	
    @PostMapping("/login")
    public String login(@RequestParam("userid") String userId, @RequestParam("password") String password, HttpSession session, Model model) {
        MemberDTO member = service.getMemberByUserId(userId);

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
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpSession session) {
        // 세션에서 userid 값 제거
        session.removeAttribute("userid");

        // 로그아웃 처리 완료 후 리다이렉트
        return "redirect:/";
    }
    

    @GetMapping("/myPage")
    public String myPage(Model model, HttpSession session) {
        // 세션에서 userid 값을 가져옴
        String userid = (String) session.getAttribute("userid");

        // userid 값을 사용하여 회원 정보를 조회
        MemberDTO member = service.getMemberByUserId(userid);
        String email = member.getEmail();
        String mobile = member.getMobile();

        // 가져온 email과 mobile 값을 모델에 저장
        model.addAttribute("userid", userid);
        model.addAttribute("email", email);
        model.addAttribute("mobile", mobile);

        return "myPage";
    }
}
