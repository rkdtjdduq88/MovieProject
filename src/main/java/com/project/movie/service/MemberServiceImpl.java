package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;

	@Override
	public boolean dupId(String userid) {
		return mapper.dupId(userid)==0 ? true:false;
	}

}
