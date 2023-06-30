package com.project.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan(basePackages = "com.project.movie") // 컴포넌트 스캔을 위해 패키지를 지정합니다.
@TestPropertySource("classpath:application.properties") // 테스트에 사용할 프로퍼티 파일을 지정합니다.
public class MemberAuthTest {
	
	@Autowired
	private DataSource ds;
	
	@Test // 테스트 메서드(파라메터 없고, 리턴타임 없음)임을 알려준다.
	public void test() {
		String sql="insert into moviememberauth_tbl(userid, authority) values(?,?)";
				
	    for (int i = 0; i < 50; i++) {
	    	
	    	try(
	    		Connection con=ds.getConnection();
	    		PreparedStatement pstmt=con.prepareStatement(sql)) {
	    		
	    		// 50명 회원 => 일반회원 20, 매니저 20, 관리자 10
	    		
	    		if(i<20) {
	    			pstmt.setString(1, "user"+i);
	    			pstmt.setString(2, "ROLE_MEMBER");
	    		}else if(i<40) {
	    			pstmt.setString(1, "manager"+i);
	    			pstmt.setString(2, "ROLE_MANAGER");
	    		}else {
	    			pstmt.setString(1, "admin"+i);
	    			pstmt.setString(2, "ROLE_ADMIN");
	    		}
	    		
	    		pstmt.executeUpdate();
	    		
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    				
	    }
			
	}
}
