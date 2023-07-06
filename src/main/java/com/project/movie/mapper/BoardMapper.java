package com.project.movie.mapper;

import java.util.List;
import java.util.Map;

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
	List<BoardDTO> getBoardListByPage(@Param("offset") int offset, @Param("recordSize") int recordSize); // 페이지당 나와야하는 개수
																											// 개수

	BoardDTO getBlogDetails(int bno); // 게시물 상세 조회
	
	int getCommentCountByBoard(int bno);//게시물당 댓글 수 
	
	void insertComment(BlogCommentDTO comment); // 댓글 입력

	BlogCommentDTO getComment(int rno);
	
	 List<BlogCommentDTO> getRepliesByComment(int rno); // 대댓글 모두 조회
	
	 void insertReply(BlogCommentDTO reply); //대댓글 입력

	void updateComment(BlogCommentDTO dto);

	void deleteComment(int rno);
	
     int insert(MemberDTO dto); // 회원가입
     
     BoardDTO getPreviousPost(@Param("bno") int bno);

     BoardDTO getNextPost(@Param("bno") int bno);//다음페이지
    
     MemberDTO getMemberByUserId(String userId);  //로그인 정보 가져오기
    List<BlogCommentDTO> getParentCommentsByBoard(int bno);
    List<BlogCommentDTO> getRepliesByParentComment(int bno);
    List<BlogCommentDTO> getCommentsByBoard(Map<String, Object> map);
    BlogCommentDTO getParentCommentByRno(int rno);
}
