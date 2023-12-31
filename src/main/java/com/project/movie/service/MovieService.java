package com.project.movie.service;


import java.util.List;

import com.project.movie.domain.MovieDetailReplyDTO;
import com.project.movie.response.BoxOfficeResult.KobisRes;
import com.project.movie.response.KmdbAndKobisDTO;
import com.project.movie.response.KmdbRes;
import com.project.movie.response.TotalRes;

public interface MovieService {
	public TotalRes movie();
	public List<KmdbRes> carouselMovie();
	public List<KmdbRes> search(String query);
	public String rankGrade(String query);
	public List<MovieDetailReplyDTO> rankGrade();	
}