package com.project.movie.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data@AllArgsConstructor@NoArgsConstructor
public class BoardDTO {
    private int bno;
    private String title;
    private String content;
    private String attach;
    private Date regDate;
    private Date updateDate;
    private Long re_ref;
    private Long re_lev;
    private Long re_seq;
    private Long cnt;
    private String userid;
    private List<AttachFileDTO> attachList;

}
