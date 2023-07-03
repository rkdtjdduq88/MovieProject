package com.project.movie.service;

import java.util.List;

import com.project.movie.domain.BlogCommentDTO;
import com.project.movie.domain.BoardDTO;
import com.project.movie.domain.MemberDTO;

public interface BoardService {
	List<BoardDTO> getBoardList(int page, int recordSize);

	int getBlogCount(); // 게시글 수 카운팅

	List<BoardDTO> getBoardListByPage(int offset, int recordSize);// 페이지별 게시물 목록 가져오기

	BoardDTO getBlogDetails(int bno);

	void insertComment(BlogCommentDTO comment);

	BlogCommentDTO getComment(int rno);

	List<BlogCommentDTO> getRepliesByComment(int rno); // 대댓글 조회 메서드 추가

	void insertReply(BlogCommentDTO reply); // 대댓글 추가 메서드 추가
	BoardDTO getPreviousPost(int bno);
    BoardDTO getNextPost(int bno);
	void updateComment(BlogCommentDTO dto);

	void deleteComment(int rno);

	boolean insert(MemberDTO dto);

	MemberDTO getMemberByUserId(String userId);

	List<BlogCommentDTO> getCommentsByBoard(int bno);

	BlogCommentDTO getParentCommentByRno(int rno);
}
