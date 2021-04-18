package com.satelite54.usetrading.service.board;

import java.security.Principal;
import java.util.List;

import com.satelite54.usetrading.model.board.dto.BoardDTO;

public interface IBoardService {
	public List<BoardDTO> getBoardPageList(int boardStartNum, int boardEndNum, String title);
	public int getTotalBoardCnt();
	// 
	// [KTH : 2021. 4. 14. ¿ÀÈÄ 9:21:38]
	public List<BoardDTO> getSearchBoardPageList(int startBlockNum, int endBlockNum, String search);
	public int getTotalBoardCnt(String search);
	
	public BoardDTO getBoardView(String BNum);
	public int setBoardViewCnt(int views, int BNum);
	public int setBoardUpdate(String BTitle, String BContent, int BNum, String email);
	public int setboardinsert(Principal principal, BoardDTO boardDTO);
	public int getboardrecentBNum();
}
