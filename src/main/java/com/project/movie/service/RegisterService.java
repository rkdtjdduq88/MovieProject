package com.project.movie.service;

import com.project.movie.domain.MemberDTO;

public interface RegisterService {
	//회원가입
	public boolean insert(MemberDTO dto);

	public boolean dupId(String userid);

	//로그인
	MemberDTO getMemberByUserId(String userid);
	
	//회원 정보 가져오기
    MemberDTO getMemberByEmail(String email);
    MemberDTO getMemberByMobile(String mobile);
    MemberDTO getMemberByName(String name);
    MemberDTO checkUser(String userid, String name, String email);
    
    //회원 정보 변경
    public boolean updatePassword(MemberDTO dto);
    public boolean updateAddress(MemberDTO dto);
    public boolean updateMobile(MemberDTO dto);
    
    //회원탈퇴
    public boolean deleteProfile(MemberDTO dto);
}
