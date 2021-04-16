package com.satelite54.usetrading.model.board.dao;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.board.dto.BoardDTO;

public interface IBoardDAO {
	public Date test();
	public List<BoardDTO> getTotalList();
	public List<BoardDTO> getDivideList(int boardStartNum, int boardEndNum, String Search);
	public int getTotalListCnt();
	// 
	// [KTH : 2021. 4. 14. ���� 9:40:59]
	public List<BoardDTO> getSearchList(int startBlockNum, int endBlockNum, String search);
	public int getTotalListCnt(String search);
	// �Խ��� �� ��ȸ
	// [KTH : 2021. 4. 16. ���� 12:10:03]
	public BoardDTO getBoardView(int BNum);
	public int setBoardViewCnt(int views, int BNum);
	public int setBoardUpdate(String BTitile, String BContent, int BNum, String email);
}
