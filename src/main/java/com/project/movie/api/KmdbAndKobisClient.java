package com.project.movie.api;

import java.net.URI;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import com.project.movie.response.KmdbItem;
import com.project.movie.response.KobisReq;
import com.project.movie.response.KobisRes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	public KobisRes searchKobis(KobisReq kobisReq) {
		URI uri = UriComponentsBuilder.fromUriString(kobisSearchUrl)									  
									  .queryParams(kobisReq.toMultiValueMap())									  
									  .encode()
									  .build()
									  .toUri();
		// 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);
		ParameterizedTypeReference<KobisRes> resReference = new ParameterizedTypeReference<KobisRes>() {};
		
		ResponseEntity<KobisRes> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, resReference);
		
		System.out.println("BoxOffice "+resEntity.getBody());
		
		return resEntity.getBody();
		
	}
	
	public KmdbRes searchKmdb(KmdbReq kmdbReq) {
		URI uri = UriComponentsBuilder.fromUriString(kmdbSearchUrl)									  
				.queryParams(kmdbReq.toMultiValueMap())									  
				.encode()
				.build()
				.toUri();
		
		
		System.out.println("uri "+uri);
		
		
		// 헤더 추가
		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);
		
        ResponseEntity<String> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, String.class);
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = null;
		
		try {
			jsonObject = (JSONObject) jsonParser.parse(resEntity.getBody());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 가장 큰 JSON 객체 response 가져오기
		String movieName = (String) jsonObject.get("Query");		
		
		JSONArray jsonArray = (JSONArray) jsonObject.get("Data");
		
		
		JSONObject jsonItems=(JSONObject) jsonArray.get(0);
		JSONArray jsonArr= (JSONArray) jsonItems.get("Result");
			
		
		JSONObject item = (JSONObject) jsonArr.get(0);

		//System.out.println("jsonArr "+jsonArr);
		
		//directors
		JSONObject directors = (JSONObject) item.get("directors");
		JSONArray directorArr = (JSONArray) directors.get("director");		
		JSONObject diretor = (JSONObject) directorArr.get(0);
		String directorNm = (String) diretor.get("directorNm");
		
		//actors
		JSONObject actors = (JSONObject) item.get("actors");
		JSONArray actorArr = (JSONArray) actors.get("actor");		
		
		List<String> actorsList = new ArrayList<String>();
		
		for (Object object : actorArr) {
		
			JSONObject jsonObj = (JSONObject) object;			
			actorsList.add((String) jsonObj.get("actorNm"));
		}	
		
		//company
		String company = (String) item.get("company");
		String type = (String) item.get("type");
		
		// plot
		JSONObject plots = (JSONObject) item.get("plots");
		JSONArray plotArr = (JSONArray) plots.get("plot");
		JSONObject plotOb = (JSONObject) plotArr.get(0);
		String plot = (String) plotOb.get("plotText");
		
		
		KmdbRes dto = new KmdbRes();
		dto.setRuntime(item.get("runtime").toString());
		dto.setTitle(movieName);
		dto.setDirectorNm(directorNm);
		dto.setActors(actorsList);
		dto.setKeywords(item.get("keywords").toString());
		dto.setReleaseDate(item.get("repRlsDate").toString());
		dto.setGenre(item.get("genre").toString());
//		dto.setPlot(item.get("plot").toString());	//**
		dto.setPlot(plot);
		dto.setAudiAcc(item.get("audiAcc").toString());
		dto.setCompany(company);
		dto.setRating(item.get("rating").toString());
		dto.setType(type);
		
		String posterUrl = item.get("posters").toString();	
		if(!posterUrl.isBlank()) {
			StringTokenizer st = new StringTokenizer(posterUrl,"|");
			if(st.hasMoreTokens()) {
				dto.setPosterUrl(st.nextToken());			
			}			
		}		
		
        // 스틸이미지 담기
        List<String> stillImages = new ArrayList<>();
        
        String stillsUrl = (String) item.get("stlls");
        if (!stillsUrl.isBlank()) {
            StringTokenizer st = new StringTokenizer(stillsUrl, "|");
            while (st.hasMoreTokens()) {
                stillImages.add(st.nextToken());
            }
        }
        dto.setStills(stillImages);
		
		return dto;
	}	
	
	public List<KmdbRes> searchMovies(KmdbReq kmdbReq) {
	    URI uri = UriComponentsBuilder.fromUriString(kmdbSearchUrl)
	            .queryParams(kmdbReq.toMultiValueMap())
	            .encode()
	            .build()
	            .toUri();

	    System.out.println("uri " + uri);

	    // 헤더 추가
	    HttpHeaders headers = new HttpHeaders();

	    HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);

	    ResponseEntity<String> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, String.class);

	    JSONParser jsonParser = new JSONParser();
	    JSONObject jsonObject = null;

	    try {
	        jsonObject = (JSONObject) jsonParser.parse(resEntity.getBody());
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }

	    /// 가장 큰 JSON 객체 response 가져오기
//	    String movieName = (String) jsonObject.get("Query");

	    JSONArray jsonArray = (JSONArray) jsonObject.get("Data");

	    List<KmdbRes> movieList = new ArrayList<>();

	        JSONObject jsonItems = (JSONObject) jsonArray.get(0);
	        JSONArray jsonArr = (JSONArray) jsonItems.get("Result");
	        for (Object jsonMovie : jsonArr) {
	            JSONObject item = (JSONObject) jsonMovie;

	            //directors
	            JSONObject directors = (JSONObject) item.get("directors");
	            JSONArray directorArr = (JSONArray) directors.get("director");
	            JSONObject diretor = (JSONObject) directorArr.get(0);
	            String directorNm = (String) diretor.get("directorNm");

	            //actors
	            JSONObject actors = (JSONObject) item.get("actors");
	            JSONArray actorArr = (JSONArray) actors.get("actor");

	            List<String> actorsList = new ArrayList<>();

	            for (Object object : actorArr) {
	                JSONObject jsonObj = (JSONObject) object;
	                actorsList.add((String) jsonObj.get("actorNm"));
	            }

	            //title
	            String title = (String) item.get("title");
	            title = title.replaceAll("!HS|!HE", "");
	            
	            
	            //company
	            String company = (String) item.get("company");
	            String type = (String) item.get("type");

	            // plot
	            JSONObject plots = (JSONObject) item.get("plots");
	            JSONArray plotArr = (JSONArray) plots.get("plot");
	            JSONObject plotOb = (JSONObject) plotArr.get(0);
	            String plot = (String) plotOb.get("plotText");

	            KmdbRes dto = new KmdbRes();
	            dto.setTitle(title);
	            dto.setRuntime(item.get("runtime").toString());
	            dto.setDirectorNm(directorNm);
	            dto.setActors(actorsList);
	            dto.setKeywords(item.get("keywords").toString());
	            dto.setReleaseDate(item.get("repRlsDate").toString());
	            dto.setGenre(item.get("genre").toString());
	            dto.setPlot(plot);
	            dto.setAudiAcc(item.get("audiAcc").toString());
	            dto.setCompany(company);
	            dto.setRating(item.get("rating").toString());
	            dto.setType(type);

	            String posterUrl = item.get("posters").toString();
	            if (!posterUrl.isBlank()) {
	                StringTokenizer st = new StringTokenizer(posterUrl, "|");
	                if (st.hasMoreTokens()) {
	                    dto.setPosterUrl(st.nextToken());
	                }
	            }
	            
	            // 스틸이미지 담기
	            List<String> stillImages = new ArrayList<>();
	            
	            String stillsUrl = (String) item.get("stlls");
	            if (!stillsUrl.isBlank()) {
	                StringTokenizer st = new StringTokenizer(stillsUrl, "|");
	                while (st.hasMoreTokens()) {
	                    stillImages.add(st.nextToken());
	                }
	            }
	            
	            dto.setStills(stillImages);

	            movieList.add(dto);
	        }

	    return movieList;
	}

	
	
	
}	
