package com.project.movie.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.project.movie.domain.FavoriteDTO;
import com.project.movie.domain.MovieDetailReplyDTO;

@Mapper
public interface FavoriteMapper {
	// 좋아요 1개 추가 및 취소
	public int addFav(FavoriteDTO dto);	
	public int deleteFav(FavoriteDTO dto);
}
