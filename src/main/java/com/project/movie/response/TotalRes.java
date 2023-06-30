package com.project.movie.response;

import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TotalRes {
	private List<KmdbAndKobisDTO> list;
	
	public TotalRes() {
		this.list = new ArrayList<KmdbAndKobisDTO>();		
	}
}
