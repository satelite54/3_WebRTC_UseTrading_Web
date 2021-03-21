package com.satelite54.usetrading.model.board.dao;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.board.dto.BoardDTO;

public interface IBoardDAO {
	public Date test();
	public List<BoardDTO> getTotalList();
	public List<BoardDTO> getDivideList(int boardStartNum, int boardEndNum, String Search);
	public int getTotalListCnt();
}
