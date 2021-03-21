package com.satelite54.usetrading.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.board.dao.IBoardDAO;
import com.satelite54.usetrading.model.board.dto.BoardDTO;

@Service
public class BoardServiceImpl implements IBoardService {

	@Inject
	IBoardDAO boardDAO;
	
	public List<BoardDTO> getBoardPageList(int boardStartNum,int boardEndNum ,String title) {
		List<BoardDTO> SearchBoardList = boardDAO.getDivideList(boardStartNum,boardEndNum, title);
		return SearchBoardList;
	}
	@Override
	public int getTotalBoardCnt() {
		return boardDAO.getTotalListCnt();
	}
}
