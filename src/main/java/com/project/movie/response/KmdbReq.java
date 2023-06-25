package com.project.movie.response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KmdbReq {
	
	private String ServiceKey = "8HPI107SND9Z42R0OM7H";	
	private String collection= "kmdb_new";
	private String query= "";		
	LocalDate today = LocalDate.now();
	String year = today.format(DateTimeFormatter.ofPattern("YYYY"));
	private String releaseDts=year;
	
	public KmdbReq(String query) {
		super();
		this.query = query;
	}	
	
	public MultiValueMap<String, String> toMultiValueMap(){
		
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		map.add("ServiceKey", ServiceKey);		
		map.add("collection", collection);
		map.add("query", query);		
		map.add("releaseDts", releaseDts);		
		
		return map;		
	}
}
