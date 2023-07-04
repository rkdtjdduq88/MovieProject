package com.project.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.movie.domain.AttachFileDTO;
import com.project.movie.domain.Criteria;
import com.project.movie.domain.MovieBoardDTO;
import com.project.movie.mapper.AttachMapper;
import com.project.movie.mapper.BoardMapper;
import com.project.movie.mapper.MovieBoardMapper;
import com.project.movie.mapper.MovieDetailReplyMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieBoardServiceImpl implements MovieBoardService {
    @Autowired
    private MovieBoardMapper mapper;
    @Autowired
    private AttachMapper attachMapper;
    @Autowired
    private MovieDetailReplyMapper remapper;

    @Override
    public List<MovieBoardDTO> getList(Criteria criteria) {
        return mapper.list(criteria);
    }

    @Transactional
    @Override
    public boolean register(MovieBoardDTO boardDTO) {
    	log.info("실행 전");
        boolean insertFlag = mapper.insert(boardDTO) == 1 ? true : false;
        log.info("실행 후"+insertFlag);
        if (boardDTO.getAttachList() == null || boardDTO.getAttachList().size() == 0) {
            return insertFlag;
        }
        boardDTO.getAttachList().forEach(attach -> {
            attach.setBno(boardDTO.getBno());
            attachMapper.insert(attach);
        });
        return insertFlag;
    }

    @Override
    public MovieBoardDTO read(int bno) {
        return mapper.read(bno);
    }

    @Transactional
    @Override
    public boolean modify(MovieBoardDTO boardDTO) {
        boolean updateFlag = mapper.modify(boardDTO) == 1 ? true : false;
        attachMapper.deleteAll(boardDTO.getBno());
        if (boardDTO.getAttachList() == null || boardDTO.getAttachList().size() == 0) {
            return updateFlag;
        }
        boardDTO.getAttachList().forEach(attach -> {
            attach.setBno(boardDTO.getBno());
            attachMapper.insert(attach);
        });
        return updateFlag;
    }

    @Override
    public int getTotalCnt(Criteria criteria) {
        return mapper.totalCnt(criteria);
    }

    @Override
    public List<AttachFileDTO> getAttachList(int bno) {
        return attachMapper.select(bno);
    }

    @Override
    public List<AttachFileDTO> oldFiles() {
        return attachMapper.oldFiles();
    }

	@Override
	public boolean remove(int bno) {
		// 첨부파일 삭제
		attachMapper.deleteAll(bno);
		
		return mapper.remove(bno)==1?true:false;
	}
}