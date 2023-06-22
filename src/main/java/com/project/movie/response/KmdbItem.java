package com.project.movie.response;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbItem {
		
	private String movieSeq;		
	private String type;			
	private String keywords;		
	private String vodUrl;	
	private String runtime;	
=======
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbItem {
	
	private String movieId;
	private String movieSeq;
	private String title;	
	private String plot;
	private String releaseDate;
	private String genre;	
	private String type;			
	private String keywords;
	private String posterUrl;	
	private String vodUrl;	
	private String runtime;
>>>>>>> branch 'kang' of https://github.com/rkdtjdduq88/MovieProject.git
		
}
