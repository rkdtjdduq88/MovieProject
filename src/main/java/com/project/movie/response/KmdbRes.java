package com.project.movie.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbRes {
		
//	private String movieId;
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
	private List<KmdbItem> kmdbItems;
	private String company;	// 제작사,배급사
	private String type;	// 타입
	private List<String> stills=new ArrayList<String>();	// 스틸 이미지
	private String prodYear;	//제작년도
}
