package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.dto.BoardDTO;
@Mapper
public interface BoardMapper {
    List<BoardDTO> getBoardList();
}
