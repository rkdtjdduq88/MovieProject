package com.project.movie.response;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KobisReq {	
		
		private String key = "7083241ea008894c70a0978fe6fbc95c";
		private String targetDt= "";
		private String itemPerPage= "10";
		private String multiMovieYn= "";
		private String repNationCd= "";
		private String wideAreaCd= "";
		
		public MultiValueMap<String, String> toMultiValueMap(){
			
			LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			
			map.add("key", key);
			map.add("targetDt", targetDt);
			map.add("itemPerPage", itemPerPage);
			map.add("multiMovieYn", multiMovieYn);
			map.add("repNationCd", repNationCd);
			map.add("wideAreaCd", wideAreaCd);
			return map;		
		}
}
