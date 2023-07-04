package com.project.movie.service;

import java.util.List;

import com.project.movie.domain.WishCriteria;
import com.project.movie.domain.WishlistDTO;

public interface WishlistService {
	public boolean insert(WishlistDTO dto);
	public List<WishlistDTO> getList(String userid, WishCriteria cri);
	public boolean delete(int wno);
	public boolean dupCheck(String userid, String title);

	int getCountByUserid(String userid);
	
}
