package com.project.movie.service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.api.KmdbAndKobisClient;
import com.project.movie.response.KmdbAndKobisDTO;
import com.project.movie.response.KmdbItem;
import com.project.movie.response.KmdbReq;
import com.project.movie.response.KmdbRes;
import com.project.movie.response.KobisItem;
import com.project.movie.response.KobisReq;
import com.project.movie.response.KobisRes;
import com.project.movie.response.TotalRes;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private KmdbAndKobisClient kmdbAndKobisClient;
	
	@Override
	public TotalRes movie(String targetDt) {
		
		// 최종 리턴
		TotalRes totalRes = new TotalRes();
		
		
		//영화진흥위원회 request 작업
		KobisReq req = new KobisReq();		
		req.setTargetDt(targetDt);	
		
		//영화진흥위원회 response 받았음(1~10위)
		KobisRes res = kmdbAndKobisClient.searchKobis(req);
		
		
		//List<KmdbRes> kmdbResList = new ArrayList<KmdbRes>();
		if(res.getBoxOfficeResult().getDailyBoxOfficeList() != null) {
			
			for(KobisItem item:res.getBoxOfficeResult().getDailyBoxOfficeList()) {
				
				KmdbAndKobisDTO dto = new KmdbAndKobisDTO();
				//영화이름 가져오기
				String movieName = item.getMovieNm();			
				
				// KMDB request 작업(1~10위까지의 박스오피스영화의 영화이름을 요청)
				KmdbReq kmdbReq = new KmdbReq(movieName);
				
				// KMDB response 받았음
				KmdbRes kmdbRes = kmdbAndKobisClient.searchKmdb(kmdbReq);
				
				//kmdbResList.add(kmdbRes);
				//최종 응답 객체 데이터 담기
				dto.setMovieNm(movieName);
				dto.setRank(item.getRank());
				dto.setPosterUrl(kmdbRes.getPosterUrl());
				dto.setGenre(kmdbRes.getGenre());
				dto.setPlot(kmdbRes.getPlot());
				dto.setReleaseDate(kmdbRes.getReleaseDate());
				totalRes.getList().add(dto);
			}	
		}
		
		return totalRes;	
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.api.KmdbAndKobisClient;
import com.project.movie.response.BoxOfficeResult;
import com.project.movie.response.KmdbAndKobisDTO;
import com.project.movie.response.KmdbItem;
import com.project.movie.response.KmdbReq;
import com.project.movie.response.KmdbRes;
import com.project.movie.response.KobisItem;
import com.project.movie.response.KobisReq;
import com.project.movie.response.KobisRes;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private KmdbAndKobisClient kmdbAndKobisClient;
	
	@Override
	public KmdbAndKobisDTO movie(String targetDt) {
		
		//영화진흥위원회 request 작업
		KobisReq req = new KobisReq();		
		req.setTargetDt(targetDt);	
		
		//영화진흥위원회 response 받았음
		BoxOfficeResult.KobisRes res = kmdbAndKobisClient.searchKobis(req);	
		//이름을 꺼내서 kmdb 요청 작업
				
		if(res.getBoxofficeType() != "") {
			// 지역 검색 중에서 첫번째 가져오기
			KobisItem kobisItem = res.getKobisItems().get(3);
			
			// 해당 가게 사진 검색하기 위해 제목 추출
			String kmdbReleaseDate = kobisItem.getOpenDt();
			
			// 이미지 검색 요청
			KmdbReq kmdbReq = new KmdbReq();
			kmdbReq.setQuery(kmdbReleaseDate);
			
			// 이미지 검색 결과 받기
			KmdbRes kmdbRes = kmdbAndKobisClient.searchKmdb(kmdbReq);
			
			if(kmdbRes.getResult() > 0) {				
				// 이미지 정보들 중에서 첫번째 가져오기
				KmdbItem kmdbItem = kmdbRes.getKmdbItems().get(0);
				
				// 받은 정보들을 원하는 데이터만 추출해서 WishListDTO 담기
				KmdbAndKobisDTO dto = new KmdbAndKobisDTO();
				dto.setGenre(kmdbItem.getGenre());
				dto.setMovieId(kmdbItem.getMovieId());
				dto.setPosterUrl(kmdbItem.getPosterUrl());
				dto.setPlot(kmdbItem.getPlot());
				dto.setMovieNm(kobisItem.getMovieNm());
				dto.setRank(kobisItem.getRank());
				return dto;
			}
		}
		return new KmdbAndKobisDTO();		
>>>>>>> branch 'kang' of https://github.com/rkdtjdduq88/MovieProject.git
	}	
}
