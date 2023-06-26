package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.movie.domain.MemberDTO;
import com.project.movie.mapper.RegisterMapper;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean insert(MemberDTO dto) {
		// 비밀번호 암호화
		String encryptedPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(encryptedPassword);

		return mapper.insert(dto) == 1 ? true : false;
	}

}
