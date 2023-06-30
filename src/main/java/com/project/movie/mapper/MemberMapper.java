package com.project.movie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public MemberDTO read(String userid);

	public int dupId(String userid);

}
