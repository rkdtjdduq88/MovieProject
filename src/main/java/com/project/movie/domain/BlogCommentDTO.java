package com.project.movie.domain;

import java.util.Date;
import java.util.List;

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
    
    private List<BlogCommentDTO> replies; // 대댓글 목록 추가
}