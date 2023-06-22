package com.project.movie.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data@AllArgsConstructor@NoArgsConstructor
public class BoardDTO {
    private int bno;
    private String title;
    private String content;
    private String attach;
    private Date regdate;
    private Date updateddate;
    private Long re_ref;
    private Long re_lev;
    private Long re_seq;
    private Long cnt;
    private String userid;


}
