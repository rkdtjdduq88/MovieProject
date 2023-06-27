package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//
//import com.project.movie.dto.CustomUser;
//import com.project.movie.dto.MemberDTO;
//import com.project.movie.mapper.BoardMapper;
//
////@Service("detail")
//public class CustomUserDetailService implements UserDetailsService {
//	@Autowired
//	private BoardMapper mapper;
//	@Override
//	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//	MemberDTO memberDTO = mapper.getMemberByUserId(userid);
//	//memberDTO �� User Ŭ���� ��� �޾Ƽ� ���� Ŭ������ �̿��ؼ� �����ؾ���
//	
//		return new CustomUser(memberDTO);
//	}
//
//}
