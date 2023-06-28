package com.project.movie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.MemberDTO;

@Mapper
public interface RegisterMapper {
    public int insert(MemberDTO dto);
    public MemberDTO getMemberByUserId(String userId);  // 로그인 정보 가져오기
    public MemberDTO getMemberByEmail(String email); // email로 멤버 정보 가져오기
    public MemberDTO getMemberByMobile(String mobile); // mobile로 멤버 정보 가져오기
    public MemberDTO getMemberByName(String name); // mobile로 멤버 정보 가져오기
    public int updatePassword(MemberDTO dto); // 비밀번호 변경
    public int updateEmail(MemberDTO dto); // 이메일 변경
    public int updateMobile(MemberDTO dto); // 전화번호 변경
}