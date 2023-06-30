package com.project.movie.service;


import java.util.List;

import com.project.movie.dto.AttachFileDTO;
import com.project.movie.dto.Criteria;
import com.project.movie.dto.MovieBoardDTO;
//import com.spring.domain.Criteria;


public interface MovieBoardService {
	// ��ü����Ʈ ��������
		public List<MovieBoardDTO> getList(Criteria criteria);
		//�۵��
		public boolean register(MovieBoardDTO boardDTO);

		// �󼼹�ȣ ��������
		public MovieBoardDTO read(int bno);

		// ���� ����
		public boolean modify(MovieBoardDTO boardDTO);
		
		//�� ����
		public boolean remove (int bno);
		//��ü�Խù� ����
		public int getTotalCnt(Criteria criteria);
		
		//÷������ ��������
		public List<AttachFileDTO> getAttachList(int bno);
		
		public List<AttachFileDTO> oldFiles();

}
