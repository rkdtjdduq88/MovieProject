package com.project.movie.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailReplyCntFavDTO {
	private int replyCnt;
	//private int rno;
	private List<MovieDetailReplyDTO> list;
}
