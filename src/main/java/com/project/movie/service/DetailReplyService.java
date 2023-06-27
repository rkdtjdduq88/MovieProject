package com.project.movie.service;

import java.util.List;

import com.project.movie.domain.MovieDetailReplyDTO;

public interface DetailReplyService {
	public List<MovieDetailReplyDTO> getList(String title);
	public boolean insert(MovieDetailReplyDTO dto);
	public boolean update(MovieDetailReplyDTO dto);
}
