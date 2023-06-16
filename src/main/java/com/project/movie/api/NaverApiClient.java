package com.project.movie.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.movie.dto.NaverMovieDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NaverApiClient {
    private final RestTemplate restTemplate;

    private final String CLIENT_ID = "vbGGJdvgWPWqUf8b6dn0";
    private final String CLIENT_SECRET = "Hgzkm68Equ";

    private final String OpenNaverMovieUrl_getRanking = "https://openapi.naver.com/v1/search/movie.json?query=%EB%8F%84%EB%9F%89&display=10"; // 영화 순위 API 엔드포인트

    public NaverMovieDTO requestMovieRanking() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(OpenNaverMovieUrl_getRanking, HttpMethod.GET, entity, NaverMovieDTO.class).getBody();
    }
}
