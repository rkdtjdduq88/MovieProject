package com.project.movie.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogCommentDTO {
	  private int re_ref;
	    private int re_lev;
	    private int re_seq;
    private int bno;
    private int rno;
    private String replyContent;
    private String userid;
    private Date replyDate;
    private Date replyUpdateDate;
//    private BlogCommentDTO parentComment;
//    private int parentRno; 
    private List<BlogCommentDTO> replies; // 대댓글 목록 추가
//    public int getParentRno() {
//        return parentRno;
//    }
//
//    public void setParentRno(int parentRno) {
//        this.parentRno = parentRno;
//    }
//    
}
