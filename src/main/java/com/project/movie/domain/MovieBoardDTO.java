package com.project.movie.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieBoardDTO {
	private int bno;
	private String title;
	private String content;
	private String attach;
	private Date regDate;
	private Date updateDate;
	private int reRef;
	private int reLev;
	private int reSeq;
	private int cnt;
	private String userId;

}
