package com.project.movie.dto;

import java.util.Date;
import java.util.List;

import com.spring.domain.AttachFileDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieBoardDTO {
	private int bno;
	private String title;
	private String userid;
	private String content;
	private Date regdate;
	private Date updatedate;
	private int replyCnt;
	//÷������ ����
	private List<AttachFileDTO> attachList;
}


