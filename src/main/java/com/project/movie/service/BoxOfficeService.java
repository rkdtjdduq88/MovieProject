package com.project.movie.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.movie.response.BoxOfficeResponse;

import java.util.List;

@Service
public class BoxOfficeService {

    private static final String API_KEY = "7083241ea008894c70a0978fe6fbc95c";

    public List<BoxOfficeResponse.Movie> getDailyBoxOfficeMovies(String date, int itemPerPage, String multiMovieYn,
                                                                 String repNationCd, String wideAreaCd) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", API_KEY)
                .queryParam("targetDt", date)
                .queryParam("itemPerPage", itemPerPage)
                .queryParam("multiMovieYn", multiMovieYn)
                .queryParam("repNationCd", repNationCd)
                .queryParam("wideAreaCd", wideAreaCd);

        BoxOfficeResponse response = restTemplate.getForObject(builder.toUriString(), BoxOfficeResponse.class);
        if (response != null && response.getBoxOfficeResult() != null) {
            return response.getBoxOfficeResult().getDailyBoxOfficeList();
        }

        return null;
    }
    
    public List<BoxOfficeResponse.Movie> getCarouselMovies(String date, int itemPerPage, String multiMovieYn,
    													   String repNationCd, String wideAreaCd) {
    	RestTemplate restTemplate = new RestTemplate();
        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", API_KEY)
                .queryParam("targetDt", date)
                .queryParam("itemPerPage", itemPerPage)
                .queryParam("multiMovieYn", multiMovieYn)
                .queryParam("repNationCd", repNationCd)
                .queryParam("wideAreaCd", wideAreaCd);

        BoxOfficeResponse response = restTemplate.getForObject(builder.toUriString(), BoxOfficeResponse.class);
        if (response != null && response.getBoxOfficeResult() != null) {
            return response.getBoxOfficeResult().getDailyBoxOfficeList();
        }

        return null;
    }
}
