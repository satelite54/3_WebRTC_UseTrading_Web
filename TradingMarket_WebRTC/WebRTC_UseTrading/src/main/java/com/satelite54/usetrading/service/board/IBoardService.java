package com.satelite54.usetrading.service.board;

import java.util.List;

import com.satelite54.usetrading.model.board.dto.BoardDTO;

public interface IBoardService {
	public List<BoardDTO> getBoardPageList(int boardStartNum, int boardEndNum, String title);
	public int getTotalBoardCnt();
	// 
	// [KTH : 2021. 4. 14. 오후 9:21:38]
	public List<BoardDTO> getSearchBoardPageList(int startBlockNum, int endBlockNum, String search);
	// 
	// [KTH : 2021. 4. 14. 오후 9:56:40]
	public int getTotalBoardSearchCnt(String search);
}
