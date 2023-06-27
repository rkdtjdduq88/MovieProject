package com.project.movie.service;

import java.time.LocalDate;
import java.util.List;

import com.project.movie.domain.AttachFileDTO;
import com.project.movie.domain.Criteria;
import com.project.movie.domain.MovieBoardDTO;
//import com.spring.domain.Criteria;

public interface MovieBoardService {
	// 전체 리스트 가져오기
	public List<MovieBoardDTO> getList(Criteria cri);

	// 글 등록
	public boolean register(MovieBoardDTO boardDTO);

	// 특정 게시물 조회
	public MovieBoardDTO read(int bno);

	// 글 수정
	public boolean modify(MovieBoardDTO boardDTO);

	// 글 삭제
	public boolean remove(int bno);

	// 전체 게시물 개수
	public int getTotalCnt(Criteria cri);

	// 첨부 파일 가져오기
	public List<AttachFileDTO> getAttachList(int bno);

}
