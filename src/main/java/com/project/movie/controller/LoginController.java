package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.movie.domain.MemberDTO;
import com.project.movie.domain.PasswordCheck;
import com.project.movie.service.MailSendService;
import com.project.movie.service.RegisterService;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@Controller
public class LoginController {
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private RegisterService service;

	
	@Autowired
	private MailSendService mailService;
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@GetMapping("/agree")
	public String AgreePage() {
		return "agree";
	}
	
	@GetMapping("/loginRegister")
	public String RegisterPage() {
		return "loginRegister";
	}
	
	@GetMapping("/findPassword")
	public String findPasswordPage() {
		return "findPassword";
	}
	
	@PostMapping("/changePass")
	public String changePassPost(MemberDTO member, Model model) {
	    String newPassword = member.getNewPassword();
	    String userid = member.getUserid();

	    if (newPassword == null || newPassword.isEmpty()) {
	        // 새 비밀번호가 비어있을 경우
	        model.addAttribute("errorMessage", "변경할 비밀번호를 입력해주세요.");
	        return "error";
	    }

	    // 데이터베이스에서 비밀번호 업데이트
	    try {
	        String encryptedPassword = passwordEncoder.encode(newPassword);
	        member.setPassword(encryptedPassword);
	        boolean success = service.updatePassword(member);

	        if (success) {
	            // 비밀번호 업데이트 성공
	            model.addAttribute("userid", userid);
	            return "redirect:/login";
	        } else {
	            // 비밀번호 업데이트 실패
	            model.addAttribute("errorMessage", "비밀번호 변경에 실패했습니다.");
	            return "error";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("errorMessage", "오류가 발생했습니다. 다시 시도해주세요.");
	        return "error";
	    }
	}
	  
	

	
	
	
	
	@PostMapping("/findPassword")
	public String findPasswordPost(MemberDTO member, Model model) {
	    String userid = member.getUserid();
	    String name = member.getName();
	    String email = member.emailMerge();

	    // 입력한 정보와 일치하는 사용자를 조회합니다.
	    MemberDTO user = service.checkUser(userid, name, email);

	    if (user != null) {
	        // 정보가 일치하면 변경 폼으로 이동합니다.
	        model.addAttribute("member", member);
	       
	        return "changePass";
	    } else {
	        // 사용자가 없는 경우 알림을 출력하고 findPassword 페이지를 다시 보여줍니다.
	        model.addAttribute("error", "회원 정보를 확인해주세요.");
	        return "findPassword";
	    }
	}

	
	
	@PostMapping("/loginRegister")
	public String insertPost(MemberDTO dto) {
		String email = dto.emailMerge();

	    try {
	        boolean insertFlag = service.insert(dto);
	        if (insertFlag) {
	        	
	        	
	            return "redirect:/login";
	        } 
	    } catch (Exception e) {
	    	e.printStackTrace();	        
	    }
	    return "loginRegister";
	}
	
	
	
	
	@RequestMapping(value = "/dupId", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody // 컨트롤러 작업이 완료될 때 결과값으로 리턴(View Resolver를 동작시키지 않는다.)
	public String dupIdCheck(String userid) {


		boolean idCheck = service.dupId(userid);

		if (idCheck) {
			return "true"; // /WEB-INF/views/test.jsp
		} else {
			return "false"; // /WEB-INF/views/false.jsp
		}
	}
	
	@GetMapping("/mailCheck/{email:.+}")
	@ResponseBody
	public String mailCheck(@PathVariable  String email) {
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
		return mailService.joinEmail(email);
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
	
//    @PostMapping("/login")
//    public String login(@RequestParam("userid") String userId, @RequestParam("password") String password, HttpSession session, Model model) {
//        MemberDTO member = service.getMemberByUserId(userId);
//
//        if (member != null && passwordEncoder.matches(password, member.getPassword())) {
//            // 로그인 성공
//            session.setAttribute("userid", userId); // 세션에 userid 저장
//            model.addAttribute("loggedIn", true); // 로그인 상태를 true로 설정
//            return "redirect:/";
//        } else {
//            // 로그인 실패
//            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
//            model.addAttribute("loggedIn", false); // 로그인 상태를 false로 설정
//            return "login";
//        }
//    }
    
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpSession session) {
//        // 세션에서 userid 값 제거
//        session.removeAttribute("userid");
//
//        // 로그아웃 처리 완료 후 리다이렉트
//        return "redirect:/";
//    }
//    

	
	@GetMapping("/mypage")
	public String mypage(Model model, Principal principal) {
	    // Principal 객체를 사용하여 현재 인증된 사용자의 정보를 가져옴
	    String userid = principal.getName();

	    // userid 값을 사용하여 회원 정보를 조회
	    MemberDTO member = service.getMemberByUserId(userid);
	    model.addAttribute("member", member);
	  
	    return "mypage";
	}
    
	@PostMapping("/changePassword")
	public String changePassword(@RequestParam("oldPassword") String oldPassword,
	                             @RequestParam("newPassword") String newPassword,
	                             Model model, Principal principal) {
		
		String userid = principal.getName();
	    MemberDTO member = service.getMemberByUserId(userid);

	    if (member != null && passwordEncoder.matches(oldPassword, member.getPassword())) {
	        // 비밀번호가 일치하면 새로운 비밀번호를 암호화하여 업데이트
	        String encryptedPassword = passwordEncoder.encode(newPassword);
	        member.setPassword(encryptedPassword);
	        boolean success = service.updatePassword(member);

	        if (success) {
	            // 비밀번호 업데이트 성공
	            model.addAttribute("userId", userid);
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

	@PostMapping("/updateAddress")
	public String updateAddress(@RequestParam("userid") String userId, @RequestParam("address") String address, Model model) {
	    if (userId != null) {
	        MemberDTO member = service.getMemberByUserId(userId);

	        if (member != null) {
	            member.setAddress(address);
	            boolean success = service.updateAddress(member);

	            if (success) {
	                // 주소 업데이트 성공
	                // mypage를 보여주기 위해 model에 필요한 데이터를 추가하고 mypage로 이동
	                model.addAttribute("address", address);
	                return "redirect:/mypage";
	            } else {
	                // 주소 업데이트 실패
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
	public String updateMobile(@RequestParam("userid") String userId, @RequestParam("mobile") String mobile, Model model) {
	    if (userId != null) {
	        MemberDTO member = service.getMemberByUserId(userId);

	        if (member != null) {
	            member.setMobile(mobile);
	            boolean success = service.updateMobile(member);

	            if (success) {
	                // 전화번호 업데이트 성공
	                // mypage를 보여주기 위해 model에 필요한 데이터를 추가하고 mypage로 이동
	                model.addAttribute("mobile", mobile);
	                return "redirect:/mypage";
	            } else {
	                // 전화번호 업데이트 실패
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
