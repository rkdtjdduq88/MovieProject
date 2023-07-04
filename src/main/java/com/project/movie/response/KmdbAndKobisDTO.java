package com.project.movie.response;

import java.util.List;

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
	
	// 특정 영화의 댓글 개수
	private int replyCnt;
	// 특정 영화의 평균 평점
	private int avgGrade;
}
