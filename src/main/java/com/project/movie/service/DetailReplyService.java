package com.project.movie.service;

import com.project.movie.domain.MovieDetailReplyDTO;
import com.project.movie.domain.MovieDetailReplyCntFavDTO;

public interface DetailReplyService {
	public MovieDetailReplyCntFavDTO getList(String title);
	//public MovieDetailReplyCntFavDTO getList(String title, int rno);
	public boolean insert(MovieDetailReplyDTO dto);
	public boolean update(MovieDetailReplyDTO dto);
	public MovieDetailReplyDTO read(int rno);
	public boolean delete(int rno);
	public int avgGrade(String title);

}
