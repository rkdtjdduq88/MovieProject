package com.project.movie.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxOfficeResponse {

    private BoxOfficeResult boxOfficeResult;

    @Data
    public static class BoxOfficeResult {
        private String boxofficeType;
        private String showRange;
        private List<Movie> dailyBoxOfficeList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Movie {
        private String movieCd;
        private String movieNm;
        private String openDt;
        private String salesAmt;
        private String audiCnt;
    }
}
