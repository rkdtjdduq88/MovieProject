package com.project.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.movie.domain.FavoriteDTO;
import com.project.movie.mapper.FavoriteMapper;
import com.project.movie.mapper.MovieDetailReplyMapper;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	private FavoriteMapper favoriteMapper;
	@Autowired
	private MovieDetailReplyMapper movieDetailReplyMapper;
	
	@Override
	@Transactional
	public boolean addFav(FavoriteDTO dto) {
			
		boolean updateFlag = favoriteMapper.addFav(dto)==1?true:false;		
		movieDetailReplyMapper.updateFav(dto.getRno(), dto.getAmount());
		
		return updateFlag; 
	}	
	@Override
	@Transactional
	public boolean deleteFav(FavoriteDTO dto) {
			
		boolean updateFlag = favoriteMapper.deleteFav(dto)==1?true:false;		
		movieDetailReplyMapper.updateFav(dto.getRno(), dto.getAmount());
		
		return updateFlag; 
	}	
	
}
