package com.satelite54.usetrading;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.satelite54.usetrading.model.board.dao.IBoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DAOTester {
    @Inject
    private IBoardDAO dao;
    
    @Test
    public void testTime() throws Exception{
        System.out.println(dao.test());
    }
    
    @Test
    public void testGetCnt() throws Exception{
    	System.out.println(dao.getTotalListCnt());
    }
}
