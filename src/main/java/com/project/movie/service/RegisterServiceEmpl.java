package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.movie.domain.AuthDTO;
import com.project.movie.domain.LoginDTO;
import com.project.movie.domain.MemberDTO;
import com.project.movie.mapper.RegisterMapper;

@Service
public class RegisterServiceEmpl implements RegisterService {

	private RegisterMapper mapper;
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public RegisterServiceEmpl(RegisterMapper mapper, BCryptPasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }
	
	@Override
	public boolean insert(MemberDTO dto) {		
		// 비밀번호 암호화
		String encryptedPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(encryptedPassword);
		
		return mapper.insert(dto)==1?true:false;
	}
	
//	@Override
//	public AuthDTO login(LoginDTO dto) {
//	    try {
//	        // 아이디와 비밀번호 가져오기
//	        String userid = dto.getUserid();
//	        String password = dto.getPassword();
//
//	        // 데이터베이스에서 암호화된 비밀번호 가져오기
//	        String encryptedPassword = mapper.getPass(userid);
//
//	        // 비밀번호 일치 여부 확인
//	        if (passwordEncoder.matches(password, encryptedPassword)) {
//	            // 로그인 성공한 경우 AuthDTO 생성
//	            AuthDTO authDTO = new AuthDTO();
//	            authDTO.setUserid(userid);
//
//	            return authDTO; // 로그인 성공 시 AuthDTO 반환
//	        } else {
//	            // 비밀번호 불일치로 로그인 실패
//	            return null; // 로그인 실패 시 null 반환
//	        }
//	    } catch (Exception e) {
//	        // 예외 발생 시
//	        e.printStackTrace(); // 예외를 콘솔에 출력
//	        return null; // 로그인 실패 시 null 반환
//	    }
//	}
	
	@Override //로그인 
	public MemberDTO getMemberByUserId(String userId) {
		return mapper.getMemberByUserId(userId);
	}
	
    @Override
    public MemberDTO getMemberByEmail(String email) {
        // RegisterMapper를 이용하여 email을 기반으로 회원 정보를 조회하는 로직을 구현합니다.
        return mapper.getMemberByEmail(email);
    }

    @Override
    public MemberDTO getMemberByMobile(String mobile) {
        // RegisterMapper를 이용하여 mobile을 기반으로 회원 정보를 조회하는 로직을 구현합니다.
        return mapper.getMemberByMobile(mobile);
    }
    
    @Override
    public MemberDTO getMemberByName(String name) {
        // RegisterMapper를 이용하여 name을 기반으로 회원 정보를 조회하는 로직을 구현합니다.
        return mapper.getMemberByMobile(name);
    }
    
    @Override
    public MemberDTO checkUser(String userid, String name, String email) {
    	return mapper.checkUser(userid, name, email);
    }
    
    @Override
    public boolean updatePassword(MemberDTO dto) {
        // 비밀번호 변경
        try {
            mapper.updatePassword(dto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean updateAddress(MemberDTO dto) {
        // 비밀번호 변경
        try {
            mapper.updateAddress(dto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean updateMobile(MemberDTO dto) {
        // 비밀번호 변경
        try {
            mapper.updateMobile(dto);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deleteProfile(MemberDTO dto){
        int result = mapper.deleteProfile(dto);
        return result > 0; // 삭제된 레코드가 있으면 true, 없으면 false 반환
    }
}
