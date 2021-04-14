package com.satelite54.usetrading;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.satelite54.usetrading.model.board.dao.BoardDAOImpl;
import com.satelite54.usetrading.model.board.dao.IBoardDAO;
import com.satelite54.usetrading.model.board.dto.BoardDTO;
import com.satelite54.usetrading.model.user.dao.IUserDAO;
import com.satelite54.usetrading.model.user.dto.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/testconfig.xml"})
public class DAOTester {

	@Autowired
    private IBoardDAO boarddao;
//    @Inject
//    private IUserDAO userdao;
//    
    @Test
    public void testTime() throws Exception{
//        System.out.println(boarddao.test());
    }
    
    @Test
    public void testGetCnt() throws Exception{
//    	System.out.println(boarddao.getTotalListCnt());
    }
    
    @Test
    public void textLogin() throws Exception {
//    	String id = "satelite12@naver.com";
//    	String pw = "1";
//    	UserDTO result = userdao.getidentify(id);
    	
//    	System.out.println(result);
    }
    
    @Test
    public void testGetListBoard() throws Exception {
    	String Search = "0010";
    	List<BoardDTO> result = boarddao.getDivideList(1, 10, Search);
    	System.out.println(result);
    }
}
