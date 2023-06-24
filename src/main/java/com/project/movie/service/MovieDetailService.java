package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.api.KmdbAndKobisClient;
import com.project.movie.response.KmdbReq;
import com.project.movie.response.KmdbRes;

@Service
public class MovieDetailService {

	@Autowired
	private KmdbAndKobisClient kmdbAndKobisClient;
	
	public KmdbRes getDetails(String movieName, String movieDate) {
		
		KmdbReq req = new KmdbReq(movieName, movieDate);
		KmdbRes res = kmdbAndKobisClient.searchKmdb(req);
		
		return res;
	}
}
