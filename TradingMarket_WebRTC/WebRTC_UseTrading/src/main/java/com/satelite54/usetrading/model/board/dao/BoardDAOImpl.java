package com.satelite54.usetrading.model.board.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.satelite54.usetrading.model.board.dto.BoardDTO;

import lombok.Setter;


@Setter
public class BoardDAOImpl implements IBoardDAO {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "com.satelite54.usetrading.model.";
	
	@Override
	public Date test() {
		return sqlSession.selectOne(NAMESPACE + "getTime");
	}
	@Override
	public  List<BoardDTO> getTotalList() {
		List<BoardDTO> userList = sqlSession.selectList("getAllBoardList");
		return userList;
	}
	@Override
	public List<BoardDTO> getDivideList(int boardStartNum, int boardEndNum, String Search) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardStartNum", boardStartNum);
		paramMap.put("boardEndNum", boardEndNum);
		paramMap.put("Search", Search);
		
		List<BoardDTO> userList = sqlSession.selectList("getBoardPageList", paramMap);
		return userList;
	}
	@Override
	public int getTotalListCnt() {
		return sqlSession.selectOne("getBoardTotalCnt");
	}
}
