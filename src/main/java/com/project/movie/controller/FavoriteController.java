package com.project.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.movie.domain.FavoriteDTO;
import com.project.movie.service.FavoriteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@PostMapping("/addFav")
	public ResponseEntity<String> addLike(@RequestBody FavoriteDTO favoriteDTO) {
		log.info("좋아요 추가"+favoriteDTO);
		
		return favoriteService.addFav(favoriteDTO)?
				new ResponseEntity<String>("success", HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@DeleteMapping("/deleteFav")
	public ResponseEntity<String> deleteLike(@RequestBody FavoriteDTO favoriteDTO) {
		log.info("좋아요 추가"+favoriteDTO);
		
		return favoriteService.deleteFav(favoriteDTO)?
				new ResponseEntity<String>("success", HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}	
}
