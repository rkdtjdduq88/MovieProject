package com.project.movie.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishlistDTO {
	private int wno;
	private String title;
	private String directorNm;
	private String releaseDate;
	private String posterUrl;
	private String userid;

}
