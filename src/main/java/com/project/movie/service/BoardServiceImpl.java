package com.project.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.movie.dto.BoardDTO;
import com.project.movie.mapper.BoardMapper;
@Repository
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = boardMapper.getBoardList();
        System.out.println(boardList); // boardList 내용 출력
        return boardList;
    }
}
