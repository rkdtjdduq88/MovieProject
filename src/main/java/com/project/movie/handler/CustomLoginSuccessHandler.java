//package com.project.movie.handler;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
////public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
////	// �α��� ���� �� ���� �������� ���ư�����
////	// �α��� ���� �� Ư�� �۾� �߰��ϰ� �Ͱų� �̵��ؾ� �ϴ� ��� ����
////	@Override
////	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
////			Authentication authentication) throws IOException, ServletException {
////		// �α��� ������� ���� Ȯ��
////		// �α��� �� ROLE_ADMIN �̶�� adminpage �̵�, ROLE_USER ��� userpage �� �̵�
////		List<String> roleNames = new ArrayList<String>();
////		authentication.getAuthorities().forEach(auth -> roleNames.add(auth.getAuthority()));
////		if(roleNames.contains("ROLE_ADMIN")){
////			response.sendRedirect("/member/admin");
////			return;
////		}
////		if(roleNames.contains("ROLE_MEMBER")|| roleNames.contains("ROLE_MANAGER")) {
////			response.sendRedirect("/board/list");
////			return;
////		}
////		response.sendRedirect("/");
////	}
//
//}
