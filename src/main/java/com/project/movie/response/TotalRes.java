package com.project.movie.response;

import java.util.ArrayList;
import java.util.List;

import com.project.movie.domain.KmdbAndKobisDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalRes {
	private List<KmdbAndKobisDTO> list;		
	
	public TotalRes() {
		this.list = new ArrayList<KmdbAndKobisDTO>();
	}
}
