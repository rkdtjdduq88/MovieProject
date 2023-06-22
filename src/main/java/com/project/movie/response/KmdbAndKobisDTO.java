package com.project.movie.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
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
			
=======
public class KmdbAndKobisDTO {
	// KMDB API 응답인자
	private String movieId;
	private String posterUrl;
	private String genre;
	private String plot;
	
	// Kobis API 응답인자
	private String movieNm;
	private String rank;
	
>>>>>>> branch 'kang' of https://github.com/rkdtjdduq88/MovieProject.git
}
