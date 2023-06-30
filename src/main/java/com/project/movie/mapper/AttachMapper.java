package com.project.movie.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.movie.dto.AttachFileDTO;

@Mapper
public interface AttachMapper {
    public int insert(AttachFileDTO dto);
    public List<AttachFileDTO> select(int bno);
    public int deleteAll(int bno);
    public List<AttachFileDTO> oldFiles();
}