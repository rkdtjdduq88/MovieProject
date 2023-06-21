package com.project.movie.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbRes {
		
	private String Result;	
	private List<KmdbItem> kmdbItems;
}
