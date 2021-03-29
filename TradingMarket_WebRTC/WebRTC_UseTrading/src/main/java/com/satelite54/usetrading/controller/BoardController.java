package com.satelite54.usetrading.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.satelite54.usetrading.model.board.dto.BoardDTO;
import com.satelite54.usetrading.service.BoardPage;
import com.satelite54.usetrading.service.BoardServiceImpl;

import dev.onvoid.webrtc.media.MediaStream;

@Controller
public class BoardController {
	
	ApplicationContext app;
	
	@Inject
	BoardServiceImpl boardService;
	
	@RequestMapping(value = {"/boardList"}, method = RequestMethod.GET)
	private String goBoardWithUserList(Model model
			,
			@RequestParam("page") String curPage,
			@RequestParam("search") String search
			) {
		int pageNum = Integer.parseInt(curPage);
		int startBlockNum = 1;
		int endBlockNum = 1;
		int pageSize = 10;
		if(pageNum == 1) {
			endBlockNum = pageNum * pageSize;
		} else {
			startBlockNum = pageNum * pageSize - pageSize;
			endBlockNum = pageSize * (pageNum + 1) - 1 - pageSize;
		}
		BoardPage page = new BoardPage();
		int PageNum = Integer.parseInt(curPage);
		page.setPageNo(PageNum);
		page.setPageSize(pageSize);//pageSize
		page.setTotalCount(boardService.getTotalBoardCnt());
		
		model.addAttribute("Page", page);
		List<BoardDTO> boardList = boardService
				.getBoardPageList(startBlockNum, endBlockNum, search);
		model.addAttribute("BoardList", boardList);
		return "community";
	}
	
	@RequestMapping(value = "/Main")
	private String goMain() {
		return "main";
	}
}
