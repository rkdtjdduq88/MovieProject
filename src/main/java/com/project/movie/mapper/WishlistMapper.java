package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.domain.WishlistDTO;

@Mapper
public interface WishlistMapper {
	public int insert(WishlistDTO dto);
	public List<WishlistDTO> readAll(String userid);
	public int delete(int wno);
	public int checkWish(String userid, String title);
}
