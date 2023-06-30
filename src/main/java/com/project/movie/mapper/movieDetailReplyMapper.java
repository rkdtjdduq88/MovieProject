package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.MovieDetailReplyDTO;


@Mapper
public interface movieDetailReplyMapper {
	public List<MovieDetailReplyDTO> detailReplyList(String title);
}