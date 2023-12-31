package com.project.movie.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieBoardDTO {
	private int bno;
	private String title;
	private String attach;
	private Date regDate;
	private Date updateDate;
	private Date updatedate;
	private int reRef;
	private int reLev;
	private int reSeq;
	private int cnt;
	private String userid;
	private String content;
    private int CommentCount;
    private String uuid;
	
	// 첨부파일 정보
	private List<AttachFileDTO> attachList;

}
