package com.project.movie.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data@AllArgsConstructor@NoArgsConstructor
public class BlogCommentDTO {
    private int bno;
    private int rno;
    private String replyContent;
    private String userid;
    private Date replyDate;
    private Date replyUpdateDate;
}