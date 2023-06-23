package com.project.movie.response;

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
		
}
