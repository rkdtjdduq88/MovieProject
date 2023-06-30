package com.project.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.domain.WishlistDTO;
import com.project.movie.mapper.WishlistMapper;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistMapper wishlistMapper;
	
	@Override
	public boolean insert(WishlistDTO dto) {

		return wishlistMapper.insert(dto)==1?true:false;
	}

	@Override
	public List<WishlistDTO> getList(String userid) {

		return wishlistMapper.readAll(userid);
	}

	@Override
	public boolean delete(int wno) {

		return wishlistMapper.delete(wno)==1?true:false;
	}

	@Override
	public boolean dupCheck(String userid, String title) {	// 중복된 정보가 있다면 1이 오니까 true 반환 없다면 0이어서 false 반환
		int count = wishlistMapper.checkWish(userid, title);
		return count > 0;
	}

}
