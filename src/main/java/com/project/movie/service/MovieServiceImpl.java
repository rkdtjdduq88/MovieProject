package com.project.movie.service;


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
	public TotalRes movie() {
		
		// 최종 리턴
		TotalRes totalRes = new TotalRes();
		
		
		//영화진흥위원회 request 작업
		KobisReq req = new KobisReq();		
			
		
		//영화진흥위원회 response 받았음(1~10위)
		KobisRes res = kmdbAndKobisClient.searchKobis(req);
		
		
		//List<KmdbRes> kmdbResList = new ArrayList<KmdbRes>();
		if(res.getBoxOfficeResult().getDailyBoxOfficeList() != null) {
			
			for(KobisItem item:res.getBoxOfficeResult().getDailyBoxOfficeList()) {
				
				KmdbAndKobisDTO dto = new KmdbAndKobisDTO();
				//영화이름 가져오기
				String movieName = item.getMovieNm();			
				// 개봉일 가져오기
				String openDt = item.getOpenDt();
				
				// KMDB request 작업(1~10위까지의 박스오피스영화의 영화이름을 요청)
				KmdbReq kmdbReq = new KmdbReq(movieName,openDt);
				
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
				dto.setAudiAcc(item.getAudiAcc());
				dto.setOpenDt(item.getOpenDt());
				totalRes.getList().add(dto);
			}	
		}		
		return totalRes;	
	}	
}