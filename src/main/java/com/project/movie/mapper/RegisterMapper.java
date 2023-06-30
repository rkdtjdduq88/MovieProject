package com.project.movie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.MemberDTO;

@Mapper
public interface RegisterMapper {
	public MemberDTO read(String userid);

	public int insert(MemberDTO dto);

}
