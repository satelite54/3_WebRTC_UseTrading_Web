package com.satelite54.usetrading.service.board;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

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
	
	@Override
	public int getTotalBoardCnt(String search) {
		return boardDAO.getTotalListCnt(search);
	}
	
	@Override
	public List<BoardDTO> getSearchBoardPageList(int startBlockNum, int endBlockNum, String search) {
		// TODO Auto-generated method stub
		return boardDAO.getSearchList(startBlockNum,endBlockNum, search);
	}
	
	@Override
	public BoardDTO getBoardView(String BNum) {
		int nBNum= Integer.parseInt(BNum);
		BoardDTO boardDTO = boardDAO.getBoardView(nBNum);
		setBoardViewCnt(boardDTO.getViews(), nBNum);
		return boardDAO.getBoardView(nBNum);
	}
	
	@Override
	public int setBoardViewCnt(int views, int BNum) {
		views++;
		return boardDAO.setBoardViewCnt(views , BNum);
	}
	
	@Override
	public int setBoardUpdate(String BTitile, String BContent, int BNum, String email) {
		return boardDAO.setBoardUpdate(BTitile, BContent, BNum, email);
	}
	
	@Override
	public int setboardinsert(Principal principal, BoardDTO boardDTO) {
		boardDTO.setId(principal.getName());
		boardDTO.setViews(0);
		boardDTO.setAuthority(1);
		return boardDAO.setboardinsert(boardDTO);
	}
	
	@Override
	public int getboardrecentBNum() {
		return boardDAO.getboardrecentBNum();
	}
}
