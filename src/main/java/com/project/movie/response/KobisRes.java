package com.project.movie.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KobisRes{
	
	private BoxOfficeResult boxOfficeResult=new BoxOfficeResult();
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class BoxOfficeResult {	
		private String boxofficeType;	//박스오피스 종류를 출력합니다.
		private String showRange; //박스오피스 조회 일자를 출력합니다.	
		private List<KobisItem> dailyBoxOfficeList;
	}
	
}

=======
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KobisRes {	
	private String boxofficeType;	//박스오피스 종류를 출력합니다.
	private String showRange; //박스오피스 조회 일자를 출력합니다.	
	private List<KobisItem> kobisItems;
}
>>>>>>> branch 'kang' of https://github.com/rkdtjdduq88/MovieProject.git
