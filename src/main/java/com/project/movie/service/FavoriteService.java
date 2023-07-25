package com.project.movie.service;

import com.project.movie.domain.FavoriteDTO;

public interface FavoriteService {
	public boolean addFav(FavoriteDTO dto);	
	public boolean deleteFav(FavoriteDTO dto);
}
