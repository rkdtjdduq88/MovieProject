package com.project.movie.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정합니다.
        response.setContentType("text/html; charset=UTF-8"); // 응답의 컨텐츠 타입을 HTML로 설정하고 문자 인코딩을 UTF-8로 설정합니다.
        PrintWriter out = response.getWriter();
        out.println("<script>alert('아이디와 비밀번호를 확인해주세요.'); window.location.href='/login?error';</script>");
    }
}