package com.project.movie.dto;

//import java.util.Collection;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import lombok.Getter;
//@Getter
//public class CustomUser extends User {
//	private MemberDTO memberDTO;
//	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//		// TODO Auto-generated constructor stub
//	}
//	public CustomUser(MemberDTO memberDTO) {
//		super(memberDTO.getUserid(),memberDTO.getPassword(), memberDTO.getAuthorities().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
//		this.memberDTO = memberDTO;
//	}
//
//}
