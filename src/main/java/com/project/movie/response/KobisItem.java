package com.project.movie.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KobisItem {
	
	private int rnum; 
	private String movieCd;
	private String movieNm;
	private String openDt;
	private String rank;
	private String audiAcc;

}
