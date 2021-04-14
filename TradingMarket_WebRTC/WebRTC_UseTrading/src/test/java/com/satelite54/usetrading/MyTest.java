package com.satelite54.usetrading;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/text/java/WEB-INF/spring/**/root-context.xml"})
public class MyTest {
	@Inject
	private DataSource ds;
	
	@Inject 
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void test() throws Exception {
		try(Connection conn = ds.getConnection()) {
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void factoryTest() {
		System.out.println(sqlFactory);
	}
	
	
	@Test
	public void sessionTest() throws Exception{
		try(SqlSession session = sqlFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}