package com.project.movie.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.movie.response.KmdbReq;
import com.project.movie.response.KmdbRes;
import com.project.movie.response.BoxOfficeResult;
import com.project.movie.response.KmdbItem;
import com.project.movie.response.KobisReq;
import com.project.movie.response.KobisRes;

@Component
public class KmdbAndKobisClient {

	@Value("${kobis.url.search.local}")
	private String kobisSearchUrl;
	
	@Value("${kobis.client.id}")
	private String kobisClientId;
	
	@Value("${kmdb.url.search.local}")
	private String kmdbSearchUrl;	
	
	@Value("${kmdb.client.id}")
	private String kmdbClientId;
	
	public BoxOfficeResult.KobisRes searchKobis(KobisReq kobisReq) {
		URI uri = UriComponentsBuilder.fromUriString(kobisSearchUrl)									  
									  .queryParams(kobisReq.toMultiValueMap())									  
									  .encode()
									  .build()
									  .toUri();
		// 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);
		ParameterizedTypeReference<BoxOfficeResult.KobisRes> resReference = new ParameterizedTypeReference<BoxOfficeResult.KobisRes>() {};
		
		ResponseEntity<BoxOfficeResult.KobisRes> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, resReference);
		return resEntity.getBody();
		
	}
	
	public KmdbRes searchKmdb(KmdbReq kmdbReq) {
		URI uri = UriComponentsBuilder.fromUriString(kmdbSearchUrl)									  
				.queryParams(kmdbReq.toMultiValueMap())									  
				.encode()
				.build()
				.toUri();
		// 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);
		ParameterizedTypeReference<KmdbRes> resReference = new ParameterizedTypeReference<KmdbRes>() {};
		
		ResponseEntity<KmdbRes> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, resReference);
		return resEntity.getBody();
		
	}
}	
