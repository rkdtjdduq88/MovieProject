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
	private String movieId;
	private String posterUrl;
	private String genre;
	private String plot;
	
	// Kobis API 응답인자
	private String movieNm;
	private String rank;
	
}
