package com.project.movie.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListPageDTO {
	private List<WishlistDTO> list;
	private int total;
}
