package com.project.movie.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailReplyDTO {
	
	private String title;
	private int rno;
	private String replyContent;
	private String userid;	
	private Date replydate;	
	private Date replyUpdatedate;
	
	
	
}
