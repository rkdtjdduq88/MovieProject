package com.project.movie.response;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbRes {
		
	private String movieId;
	private String title;	//영화명
	private String directorNm;	//감독명
	private List<String> actors=new ArrayList<String>();	//배우명 actors
	private String plot;	//줄거리
	private String runtime;	//상영시간
	private String rating;	//대표관람등급
	private String genre;	//장르
	private String releaseDate;	//개봉일자
	private String keywords;	//키워드
	private String posterUrl;	//포스터이미지
	private String audiAcc;	//누적관람인원
=======
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbRes {
		
	private String Result;	
>>>>>>> branch 'kang' of https://github.com/rkdtjdduq88/MovieProject.git
	private List<KmdbItem> kmdbItems;
}
