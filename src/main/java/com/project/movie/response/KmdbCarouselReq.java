package com.project.movie.response;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;


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
public class KmdbCarouselReq {
	
	private String ServiceKey = "8HPI107SND9Z42R0OM7H";	
	private String collection= "kmdb_new";
	private String query= "";		
	
	// 현재 날짜를 가져오기
    LocalDate currentDate = LocalDate.now();
    
    // 현재 날짜의 연도와 월을 가져오기
    int year = currentDate.getYear();
    int month = currentDate.getMonthValue();
    
    // 그해 그월의 첫 날짜를 생성
    LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
    
    // 그해 그월의 마지막 날짜를 생성
    YearMonth yearMonth = YearMonth.of(year, month);
    LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();
    
    // 개봉일과 개봉종료일을 원하는 형식으로 출력
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
   
	private String releaseDts=firstDayOfMonth.format(formatter);;
	private String releaseDte=lastDayOfMonth.format(formatter);;
	
		public KmdbCarouselReq(String query) {
			super();
			this.query = query;
		}	
	   
	
	   public KmdbCarouselReq(String query, String releaseDts, String releaseDte) {
		   super();
		   this.query = query;
		   this.releaseDts = releaseDts;
		   this.releaseDte = releaseDte;
	   }
	
	   
	public MultiValueMap<String, String> toMultiValueMap(){
		
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		map.add("ServiceKey", ServiceKey);		
		map.add("collection", collection);
		map.add("query", query);		
		map.add("releaseDts", releaseDts);		
		map.add("releaseDte", releaseDte);		
		
		return map;		
	}

}
