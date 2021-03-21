package com.satelite54.usetrading.model.board.dto;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository
public class BoardDTO {
	
	private int BNum;
	private String BTitle;
	private String BContent;
	private String BDate;
	private String id;
	private int authority;
	private int views;
	
	@Override
	public String toString() {
		return "Board [BNum=" + BNum + ", BTitle=" + BTitle + ", BContent=" + BContent + ", BDate=" + BDate + ", id="
				+ id + ", authority=" + authority + ", views=" + views + "]";
	}

}

