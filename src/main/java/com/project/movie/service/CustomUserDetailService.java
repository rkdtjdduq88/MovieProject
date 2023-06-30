package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.movie.domain.CustomUser;
import com.project.movie.domain.MemberDTO;
import com.project.movie.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

//@Service("detail")
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		
		
		log.info("userid : {}",userid);
		

		MemberDTO memberDTO=mapper.read(userid);
		
		// memberDTO는 User 클래스를 상속 받아서 만든 클래스를 이용해서 리턴해야 한다.
		
		return new CustomUser(memberDTO);
	}

}
