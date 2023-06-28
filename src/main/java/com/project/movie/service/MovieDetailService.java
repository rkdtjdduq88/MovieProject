package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.api.KmdbAndKobisClient;
import com.project.movie.response.KmdbReq;
import com.project.movie.response.KmdbRes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieDetailService {

	@Autowired
	private KmdbAndKobisClient kmdbAndKobisClient;
	
	
	public KmdbRes getDetails(String movieNm, String movieDt) {
		
		
		KmdbReq req = new KmdbReq(movieNm.replaceAll("[\\s!]", ""), movieDt);
		log.info("req 영화제목 확인 "+req);
		KmdbRes res = kmdbAndKobisClient.searchKmdb(req);
		log.info("스틸컷 넘어오는지"+res.getStills());
		return res;
	}
}
