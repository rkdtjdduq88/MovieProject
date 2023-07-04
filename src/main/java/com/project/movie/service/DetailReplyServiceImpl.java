package com.project.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.domain.MovieDetailReplyDTO;
import com.project.movie.domain.MovieDetailReplyCntFavDTO;
import com.project.movie.mapper.FavoriteMapper;
import com.project.movie.mapper.MovieDetailReplyMapper;

@Service
public class DetailReplyServiceImpl implements DetailReplyService {
	
	@Autowired
	private MovieDetailReplyMapper movieDetailReplyMapper;
	@Autowired
	private FavoriteMapper favoriteMapper;
	

	// 리뷰댓글 전체 조회
	@Override
	public MovieDetailReplyCntFavDTO getList(String title) {
		// 기존 리뷰댓글 전체 목록 조회
		List<MovieDetailReplyDTO> list = movieDetailReplyMapper.detailReplyList(title);
		// 특정 영화에 대한 리뷰댓글 총 개수 조회 기능 추가
		int replyCnt = movieDetailReplyMapper.getCountByTitle(title);
		// 기존 댓글번호에 좋아요 테이블의 댓글번호 매핑		
		//favoriteMapper.getFavoriteCountOne(rno);
		
		return new MovieDetailReplyCntFavDTO(replyCnt, list);
	}
	
	// 리뷰댓글 작성
	@Override
	public boolean insert(MovieDetailReplyDTO dto) {

		return movieDetailReplyMapper.insert(dto)==1?true:false;
	}
	
	// 리뷰댓글 수정
	@Override
	public boolean update(MovieDetailReplyDTO dto) {		
		return movieDetailReplyMapper.update(dto)==1?true:false;
	}
	
	// 특정 리뷰댓글 조회
	@Override
	public MovieDetailReplyDTO read(int rno) {		
		return movieDetailReplyMapper.read(rno);
	}
	
	// 리뷰댓글 삭제
	@Override
	public boolean delete(int rno) {		
		return movieDetailReplyMapper.delete(rno)==1?true:false;
	}
	
	// 특정 영화마다 별점 평균 조회하기
	@Override
	public int avgGrade(String title) {		
		return movieDetailReplyMapper.avgGrade(title);
	}

}