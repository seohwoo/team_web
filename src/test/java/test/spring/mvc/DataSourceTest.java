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

@RunWith(SpringJUnit4ClassRunner.class)	//������ ���� ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;	//���� DB ��ü
	
	@Autowired
	private SqlSessionFactory sqlSession; //mybatis ��ü
	
	@Test	//�ش� �޼��� ����
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
