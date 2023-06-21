package com.project.movie.service;

import com.project.movie.response.KmdbAndKobisDTO;

public interface MovieService {
	public KmdbAndKobisDTO movie(String targetDt);
}
