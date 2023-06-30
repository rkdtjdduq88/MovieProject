package com.project.movie.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.FavoriteDTO;

@Mapper
public interface FavoriteMapper {
	public FavoriteDTO getFavoriteCountOne(int rno);
}
