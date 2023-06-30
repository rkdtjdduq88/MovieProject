package com.project.movie.response;


import org.springframework.stereotype.Component;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class KmdbReq {
	
	private String ServiceKey = "8HPI107SND9Z42R0OM7H";	
	private String query= "";		
	private String releaseDts = "";	

	
		public KmdbReq(String query) {
			super();
			this.query = query;
		}	
	   
	
	   public KmdbReq(String query, String releaseDts) {
		   super();
		   this.query = query;
		   this.releaseDts = releaseDts;
	   }
	
	   
	public MultiValueMap<String, String> toMultiValueMap(){
		
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		map.add("ServiceKey", ServiceKey);		
		map.add("query", query);		
		map.add("releaseDts", releaseDts);		
		
		return map;		
	}
	

}
