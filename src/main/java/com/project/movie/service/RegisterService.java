package com.project.movie.service;

import com.project.movie.domain.AuthDTO;
import com.project.movie.domain.LoginDTO;
import com.project.movie.domain.MemberDTO;

public interface RegisterService {
	//회원가입
	public boolean insert(MemberDTO dto);
	
	//로그인
	public AuthDTO login(LoginDTO dto);
}
