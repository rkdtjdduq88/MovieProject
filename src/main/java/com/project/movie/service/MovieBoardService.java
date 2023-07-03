package com.project.movie.service;


import java.util.List;

import com.project.movie.domain.AttachFileDTO;
import com.project.movie.domain.Criteria;
import com.project.movie.domain.MovieBoardDTO;
//import com.spring.domain.Criteria;


public interface MovieBoardService {

		public List<MovieBoardDTO> getList(Criteria criteria);
	
		public boolean register(MovieBoardDTO boardDTO);

		
		public MovieBoardDTO read(int bno);

	
		public boolean modify(MovieBoardDTO boardDTO);
		
	
		public boolean remove (int bno);
	
		public int getTotalCnt(Criteria criteria);
		
		
		public List<AttachFileDTO> getAttachList(int bno);
		
		public List<AttachFileDTO> oldFiles();

}