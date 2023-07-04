package com.project.movie.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.util.List;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {

	private String userid;
	private String password;
	private String email;
	private String address;
	private String name;
	private String mobile;
	
	private String newPassword;
	
	private List<MemberAuthDTO> authorities;

	
	//비밀번호 찾기용
	private String userEmail1;
	private String userEmail2;
	
	public String emailMerge() {
		this.email = userEmail1.concat(userEmail2);	
		return email;
	}

}
