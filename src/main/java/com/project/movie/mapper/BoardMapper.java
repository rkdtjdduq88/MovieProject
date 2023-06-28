package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.movie.domain.BlogCommentDTO;
import com.project.movie.domain.BoardDTO;
import com.project.movie.domain.MemberDTO;
import com.project.movie.domain.PageDTO;

@Mapper
public interface BoardMapper {
	List<BoardDTO> getBoardList();// 게시글 리스트 조회

	int getBlogCount(); // 게시글 수

	List<BoardDTO> getBoardListByPage(@Param("offset") int offset, @Param("recordSize") int recordSize); // 페이지당 나와야하는
																											// 개수
	BoardDTO getBlogDetails(int bno); // 게시물 상세 조회

	void insertComment(BlogCommentDTO comment); // 댓글 입력

	BlogCommentDTO getComment(int rno);

	List<BlogCommentDTO> getCommentsByBoard(int bno);

	void updateComment(BlogCommentDTO comment);

	void deleteComment(int rno);

	int insert(MemberDTO dto); // 회원가입

	MemberDTO getMemberByUserId(String userId); // 로그인 정보 가져오기

}
