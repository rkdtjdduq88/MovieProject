package com.project.movie.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KobisRes {	
	private String boxofficeType;	//박스오피스 종류를 출력합니다.
	private String showRange; //박스오피스 조회 일자를 출력합니다.	
	private List<KobisItem> kobisItems;
}
