package test.spring.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)	//스프링 실행 역할
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;	//기존 DB 객체
	
	@Autowired
	private SqlSessionFactory sqlSession; //mybatis 객체
	
	@Test	//해당 메서드 실행
	public void oracleDB() {
		try {
			System.out.println("sqlSessionFactory : " + sqlSession);
			
			/*
			 * Connection conn = dataSource.getConnection(); PreparedStatement pstmt =
			 * conn.prepareStatement("select * from emp where sal >= ?"); pstmt.setInt(1,
			 * 2000); ResultSet rs = pstmt.executeQuery();
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
