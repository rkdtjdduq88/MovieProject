package com.project.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data@AllArgsConstructor  
public class PageDTO {
	//블로그
	private int page; // 현재 페이지 번호
	private int recordSize; // 페이지당 출력할 데이터 개수
	private int pageSize; // 화면 하단에 출력할 페이지 사이즈
	private String keyword; // 검색 키워드
	private String searchType; // 검색 유형
	
	

	public PageDTO() {
		this.page = 1;
		this.recordSize = 10;
		this.pageSize = 10;
	}

	public int getOffset() {
		return (page - 1) * recordSize;
	}
	
	
	
	//메인보드
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.total=total;
		this.cri=cri;
		
		this.endPage=(int)(Math.ceil(cri.getPage()/10.0))*10;
		this.startPage=this.endPage-9;
		
		int realEnd=(int)(Math.ceil((total/1.0)/cri.getAmount()));
		if(realEnd<this.endPage) {
			this.endPage=realEnd;
		}
		this.prev=this.startPage>1; // 2,3,4 부터는 이전 페이지 클릭 가능
		this.next=this.endPage<realEnd;
	}


}
