package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.movie.domain.WishCriteria;
import com.project.movie.domain.WishlistDTO;

@Mapper
public interface WishlistMapper {
	public int insert(WishlistDTO dto);
	public List<WishlistDTO> readAll(@Param("userid")  String userid, @Param("cri") WishCriteria cri);
	public int delete(int wno);
	public int checkWish(String userid, String title);
	public int getCountByUserid(String userid);
}
