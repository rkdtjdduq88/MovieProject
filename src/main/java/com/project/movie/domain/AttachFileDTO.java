package com.project.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class AttachFileDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType;
	private int bno;

}
