package com.project.movie.domain;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	
	private String userid;
	private String password;
	private String email;
	private String address;
	private String name;
	private String mobile;
	
	private List<MemberAuthDTO> authorities;

}
