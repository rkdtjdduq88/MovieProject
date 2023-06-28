package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.movie.domain.MemberDTO;
import com.project.movie.domain.PasswordCheck;
import com.project.movie.service.RegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
	        return ResponseEntity.ok().body("{\"success\": false, \"message\": \"사용할 수 없는 아이디입니다. 다른 아이디를 입력해 주세요.\"}");
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
    

    @GetMapping("/mypage")
    public String mypage(Model model, HttpSession session) {
        // 세션에서 userid 값을 가져옴
        String userid = (String) session.getAttribute("userid");

        // userid 값을 사용하여 회원 정보를 조회
        MemberDTO member = service.getMemberByUserId(userid);
        String email = member.getEmail();
        String mobile = member.getMobile();
        String name = member.getName();

        // 가져온 email과 mobile 값을 모델에 저장
        model.addAttribute("userid", userid);
        model.addAttribute("email", email);
        model.addAttribute("mobile", mobile);
        model.addAttribute("name", name);

        return "mypage";
    }
    
    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("userId") String userId,
                                 @RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 Model model) {
        MemberDTO member = service.getMemberByUserId(userId);

        if (member != null && passwordEncoder.matches(oldPassword, member.getPassword())) {
            // 비밀번호가 일치하면 새로운 비밀번호를 암호화하여 업데이트
            String encryptedPassword = passwordEncoder.encode(newPassword);
            member.setPassword(encryptedPassword);
            boolean success = service.updatePassword(member);

            if (success) {
                // 비밀번호 업데이트 성공
                model.addAttribute("userId", userId);
                return "redirect:/mypage";
            } else {
                // 비밀번호 업데이트 실패
                return "error";
            }
        } else {
            // 기존 비밀번호가 일치하지 않는 경우
            return "error";
        }
    }
    
    @PostMapping("/deleteProfile")
    public String deleteProfile(@RequestParam("userId") String userId,
                                @RequestParam("password") String password,
                                HttpSession session) {
        MemberDTO member = service.getMemberByUserId(userId);

        if (member != null && passwordEncoder.matches(password, member.getPassword())) {
            // 비밀번호가 일치하면 회원 탈퇴 수행
            boolean success = service.deleteProfile(member);

            if (success) {
                // 회원 탈퇴 성공
                session.removeAttribute("userid"); // 세션에서 userid 제거
                return "success";
            } else {
                // 회원 탈퇴 실패
                return "error";
            }
        } else {
            // 기존 비밀번호가 일치하지 않는 경우
            return "error";
        }
    }
    
    
    @PostMapping("/updateEmail")
    public String updateEmail(@RequestParam("userId") String userId, @RequestParam("email") String email, Model model) {
        if (userId != null) {
            MemberDTO member = service.getMemberByUserId(userId);

            if (member != null) {
                member.setEmail(email);
                boolean success = service.updateEmail(member);

                if (success) {
                    // 이메일 업데이트 성공
                    // mypage를 보여주기 위해 model에 필요한 데이터를 추가하고 mypage로 이동
                    model.addAttribute("email", email);
                    return "redirect:/mypage";
                } else {
                    // 이메일 업데이트 실패
                    // 실패에 대한 처리를 진행하거나 에러 페이지로 이동
                    return "error"; // 예시로 "error"라는 뷰 이름을 사용했습니다.
                }
            } else {
                // 로그인 사용자 정보를 찾을 수 없는 경우
                // 처리를 진행하거나 에러 페이지로 이동
                return "error"; // 예시로 "error"라는 뷰 이름을 사용했습니다.
            }
        } else {
            // userId가 없는 경우
            // 처리를 진행하거나 에러 페이지로 이동
            return "error"; // 예시로 "error"라는 뷰 이름을 사용했습니다.
        }
    }
    
    @PostMapping("/updateMobile")
    public String updateMobile(@RequestParam("userId") String userId, @RequestParam("mobile") String mobile, Model model) {
        if (userId != null) {
            MemberDTO member = service.getMemberByUserId(userId);

            if (member != null) {
                member.setMobile(mobile);
                boolean success = service.updateMobile(member);

                if (success) {
                    // 이메일 업데이트 성공
                    // mypage를 보여주기 위해 model에 필요한 데이터를 추가하고 mypage로 이동
                    model.addAttribute("mobile", mobile);
                    return "redirect:/mypage";
                } else {
                    // 이메일 업데이트 실패
                    // 실패에 대한 처리를 진행하거나 에러 페이지로 이동
                    return "error"; // 예시로 "error"라는 뷰 이름을 사용했습니다.
                }
            } else {
                // 로그인 사용자 정보를 찾을 수 없는 경우
                // 처리를 진행하거나 에러 페이지로 이동
                return "error"; // 예시로 "error"라는 뷰 이름을 사용했습니다.
            }
        } else {
            // userId가 없는 경우
            // 처리를 진행하거나 에러 페이지로 이동
            return "error"; // 예시로 "error"라는 뷰 이름을 사용했습니다.
        }
    }
    
}
