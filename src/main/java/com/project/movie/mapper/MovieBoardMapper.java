package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.movie.dto.MovieBoardDTO;
import com.project.movie.dto.Criteria;
@Mapper
public interface MovieBoardMapper {
	public List<MovieBoardDTO> getList(Criteria criteria);
	public int register(MovieBoardDTO boardDTO);
	public MovieBoardDTO read (int bno);
	public int modify (MovieBoardDTO boardDTO);
	public int remove(int bno);
	public int totalCnt(Criteria criteria);
	public int updateReplyCnt(@Param("bno")int bno, @Param ("amount") int amount);
	
	//�� ��ȸ + ��������
	public MovieBoardDTO readAttach (int bno);
}
