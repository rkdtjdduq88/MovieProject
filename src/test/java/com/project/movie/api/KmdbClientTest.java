package com.project.movie.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.project.movie.response.KmdbReq;
import com.project.movie.response.KmdbRes;

@SpringBootTest
public class KmdbClientTest {
	
	@Autowired
	private KmdbAndKobisClient client;

	
	@Test
	public void clientTest() {
		
		KmdbReq req = new KmdbReq("범죄도시3");
		
		KmdbRes res = client.searchKmdb(req);
		
		System.out.println("kmdb로부터 받은 데이터 확인 ======");
		System.out.println(res);
		
	}
}
