package com.project.movie.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.project.movie.domain.Criteria;
import com.project.movie.domain.MovieBoardDTO;

@Mapper
public interface MovieBoardMapper {
	public List<MovieBoardDTO> list(Criteria cri);
	public int insert(MovieBoardDTO boardDTO);
	public MovieBoardDTO read(int bno);
	public int modify(MovieBoardDTO boardDTO);
	public int remove(int bno);
	public int totalCnt(Criteria cri);
//	public int updateReplyCnt(@Param("bno") int bno, @Param("amount") int amount);
	
	// 상세조회 + 파일정보
	public MovieBoardDTO readAttach(int bno);

}
