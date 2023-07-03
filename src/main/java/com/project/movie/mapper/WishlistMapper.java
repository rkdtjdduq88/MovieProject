package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.movie.domain.WishlistDTO;

@Mapper
public interface WishlistMapper {
	public int insert(WishlistDTO dto);
	public List<WishlistDTO> readAll(String userid);
	public int delete(int wno);
	public int checkWish(String userid, String title);
	public int getCountByUserid(String userid);
 public List<WishlistDTO> getListByPage(@Param("userid") String userid, @Param("offset") int offset, @Param("recordSize") int recordSize);
}
