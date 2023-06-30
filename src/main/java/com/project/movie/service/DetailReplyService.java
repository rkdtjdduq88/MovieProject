package com.project.movie.service;

import java.util.List;

import com.project.movie.domain.MovieDetailReplyDTO;
import com.project.movie.domain.MovieDetailReplyCntFavDTO;

public interface DetailReplyService {
	//public List<MovieDetailReplyDTO> getList(String title);
	public MovieDetailReplyCntFavDTO getList(String title);
	public boolean insert(MovieDetailReplyDTO dto);
	public boolean update(MovieDetailReplyDTO dto);
	public MovieDetailReplyDTO read(int rno);
	public boolean delete(int rno);
}
