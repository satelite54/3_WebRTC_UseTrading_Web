package com.satelite54.usetrading;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.satelite54.usetrading.model.board.dao.IBoardDAO;
import com.satelite54.usetrading.model.user.dao.IUserDAO;
import com.satelite54.usetrading.model.user.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DAOTester {
    @Inject
    private IBoardDAO boarddao;
    
    @Inject
    private IUserDAO userdao;
    
    @Test
    public void testTime() throws Exception{
        System.out.println(boarddao.test());
    }
    
    @Test
    public void testGetCnt() throws Exception{
    	System.out.println(boarddao.getTotalListCnt());
    }
    
    @Test
    public void textLogin() throws Exception {
    	String id = "satelite12@naver.com";
    	String pw = "1";
    	int result = userdao.getidentify(id, pw);
    	
    	System.out.println(result);
    }
}
