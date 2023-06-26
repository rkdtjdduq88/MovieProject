package com.project.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbAndKobisDTO {	
	
	// KMDB API 응답인자
	//private String movieId;
	private String posterUrl;
	private String genre;
	private String plot;
	private String releaseDate;
	
	// Kobis API 응답인자	
	private String movieNm;
	private String rank;
	private String openDt;
	private String audiAcc;
}
