package com.project.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.dto.MovieDetailReplyDTO;
import com.project.movie.mapper.movieDetailReplyMapper;

@Service
public class DetailReplyServiceImpl implements DetailReplyService {
	
	@Autowired
	private movieDetailReplyMapper movieDetailReplyMapper;
	
	@Override
	public List<MovieDetailReplyDTO> getList(String title) {
		
		return movieDetailReplyMapper.detailReplyList(title);
	}
	
	@Override
	public boolean insert(MovieDetailReplyDTO dto) {

		return movieDetailReplyMapper.insert(dto)==1?true:false;
	}

}
