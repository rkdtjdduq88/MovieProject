package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.project.movie.domain.MovieDetailReplyDTO;

@Mapper
public interface MovieDetailReplyMapper {
	public List<MovieDetailReplyDTO> detailReplyList(String title);
	public int insert(MovieDetailReplyDTO dto);
	public int update(MovieDetailReplyDTO dto);
	public MovieDetailReplyDTO read(int rno);
	public int delete(int rno);
	public int getCountByTitle(String title);
	public int avgGrade(String title);
}
