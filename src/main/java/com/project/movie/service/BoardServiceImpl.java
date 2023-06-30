package com.project.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.movie.dto.BlogCommentDTO;
import com.project.movie.dto.BoardDTO;
import com.project.movie.dto.MemberDTO;
import com.project.movie.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
	public List<BlogCommentDTO> getRepliesByComment(int rno) {
		return boardMapper.getRepliesByComment(rno);
	}

	@Override
	public void updateComment(BlogCommentDTO dto) {
		boardMapper.updateComment(dto);
	}

	@Override
	public void deleteComment(int rno) {
		boardMapper.deleteComment(rno);
	}

	@Override
	public List<BoardDTO> getBoardListByPage(int offset, int recordSize) {
		return boardMapper.getBoardListByPage(offset, recordSize);
	}

	@Override
	public void insertReply(BlogCommentDTO reply) {
		boardMapper.insertReply(reply);
	}

	@Override
	public boolean insert(MemberDTO dto) {
		String encryptedPassword = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(encryptedPassword);
		return boardMapper.insert(dto) == 1;
	}

	@Override //로그인 
	public MemberDTO getMemberByUserId(String userId) {
		return boardMapper.getMemberByUserId(userId);
	}

	  @Override
	    public List<BlogCommentDTO> getCommentsByBoard (int bno) {
	        Map<String, Object> map = new HashMap<>();
	        map.put("bno", bno);
	        return boardMapper.getCommentsByBoard(map);
	    }


	@Override
	public BlogCommentDTO getParentCommentByRno(int rno) {
		return boardMapper.getParentCommentByRno(rno);
	}

}
