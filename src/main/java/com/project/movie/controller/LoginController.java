package com.project.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.movie.domain.MemberDTO;
import com.project.movie.service.BoardService;
import com.project.movie.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private BoardService service;
	
	@Autowired
	private MemberService mservice;

	 @GetMapping("/login")
	    public String loginPage(Model model) {
	        model.addAttribute("loggedIn", false); // 로그인 상태를 false로 설정
	        return "login";
	    }

	     @PostMapping("/login")
	     public String login(@RequestParam("userid") String userId, @RequestParam("password") String password, HttpSession session, Model model) {
	    	 MemberDTO member=service.getMemberByUserId(userId);

	         if (member != null && passwordEncoder.matches(password, member.getPassword())) {
	             // 로그인 성공
	             session.setAttribute("userid", userId); // 세션에 userid 저장
	             model.addAttribute("loggedIn", true); // 로그인 상태를 true로 설정
	             return "redirect:/";
	         } else {
	             // 로그인 실패
	        	 log.info("실패");
	             model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
	             model.addAttribute("loggedIn", false); // 로그인 상태를 false로 설정
	             return "/login";
	         }
	     }
	     
	     @GetMapping("/logout")
	     public String logout(HttpServletRequest request, HttpSession session) {
	    	session.removeAttribute("authDTO");
	 		// session 해제 index 이동
	 		return "redirect:/";
	     }

	@GetMapping("/agree")
	public String AgreePage() {
		return "agree";
	}

	@GetMapping("/login-register")
	public String RegisterPage() {
		return "login-register";
	}

	@PostMapping("/login-register")
	public ResponseEntity<Object> insertPost(MemberDTO dto) {
		try {
			boolean insertFlag = service.insert(dto);
			if (insertFlag) {
				return ResponseEntity.ok().body("{\"success\": true, \"message\": \"회원가입이 성공적으로 완료되었습니다.\"}");
			} else {
				return ResponseEntity.ok().body("{\"success\": false, \"message\": \"회원가입에 실패했습니다. 다시 시도해주세요.\"}");
			}
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"success\": false, \"message\": \"역시나 회원가입에 실패했습니다. 다시 시도해주세요.\"}");
		}
	}

	// 중복 아이디 점검
	@RequestMapping(value = "/dupId", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody // 컨트롤러 작업이 완료될 때 결과값으로 리턴(View Resolver를 동작시키지 않는다.)
	public String dupIdCheck(String userid) {
		log.info("duplicate request " + userid);

		boolean idCheck = mservice.dupId(userid);

		if (idCheck) {
			return "true"; // /WEB-INF/views/test.jsp
		} else {
			return "false"; // /WEB-INF/views/false.jsp
		}
	}

}
