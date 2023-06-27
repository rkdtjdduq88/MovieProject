package com.project.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.movie.domain.BlogCommentDTO;
import com.project.movie.domain.BoardDTO;
import com.project.movie.domain.MemberDTO;
import com.project.movie.mapper.BoardMapper;

@Repository
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;  // Use PasswordEncoder instead of BCryptPasswordEncoder

	@Override
	public List<BoardDTO> getBoardList(int page, int recordSize) {
		List<BoardDTO> boardList = boardMapper.getBoardList();
		System.out.println(boardList); // boardList 내용 출력
		return boardList;
	}

	@Override
	public int getBlogCount() {

		return boardMapper.getBlogCount();
	}

	@Override
	public BoardDTO getBlogDetails(int bno) {

		return boardMapper.getBlogDetails(bno);
	}

	@Override
	public void insertComment(BlogCommentDTO comment) {
		boardMapper.insertComment(comment);
	}

	@Override
	public BlogCommentDTO getComment(int rno) {
		return boardMapper.getComment(rno);
	}

	@Override
	public List<BlogCommentDTO> getCommentsByBoard(int bno) {
		return boardMapper.getCommentsByBoard(bno);
	}

	@Override
	public void updateComment(BlogCommentDTO comment) {
		boardMapper.updateComment(comment);
	}

	@Override
	public void deleteComment(int rno) {
		boardMapper.deleteComment(rno);
	}

	@Override
	public List<BoardDTO> getBoardListByPage(int offset, int recordSize) {
		return boardMapper.getBoardListByPage(offset, recordSize);
	}
	
	@Override // 회원가입
	public boolean insert(MemberDTO dto) {
		// 비밀번호 암호화
		String encryptedPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(encryptedPassword);

		return boardMapper.insert(dto) == 1;
	}

	@Override //로그인 
	public MemberDTO getMemberByUserId(String userId) {
		return boardMapper.getMemberByUserId(userId);
	}
}
