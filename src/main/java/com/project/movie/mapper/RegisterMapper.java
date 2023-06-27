package com.project.movie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.AuthDTO;
import com.project.movie.domain.MemberDTO;

@Mapper
public interface RegisterMapper {
	public int insert(MemberDTO dto);
	public String getPass(String userid);
	public MemberDTO login(String userid);
}
