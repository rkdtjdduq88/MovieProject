package com.project.movie.service;

import com.project.movie.domain.MemberDTO;

public interface RegisterService {
	//회원가입
	public boolean insert(MemberDTO dto);
	
	//로그인
	MemberDTO getMemberByUserId(String userId);
	
	//회원 정보 가져오기
    MemberDTO getMemberByEmail(String email);
    MemberDTO getMemberByMobile(String mobile);
    MemberDTO getMemberByName(String name);
    
    //회원 정보 변경
    public boolean updatePassword(MemberDTO dto);
    public boolean updateAddress(MemberDTO dto);
    public boolean updateMobile(MemberDTO dto);
    
    //회원탈퇴
    public boolean deleteProfile(MemberDTO dto);
}
