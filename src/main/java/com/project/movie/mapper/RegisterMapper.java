package com.project.movie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.MemberDTO;

@Mapper
public interface RegisterMapper {
    public int insert(MemberDTO dto);
    public MemberDTO getMemberByUserId(String userId);  // 로그인 정보 가져오기
    public MemberDTO getMemberByEmail(String email); // email로 멤버 정보 가져오기
    public MemberDTO getMemberByMobile(String mobile); // mobile로 멤버 정보 가져오기
}