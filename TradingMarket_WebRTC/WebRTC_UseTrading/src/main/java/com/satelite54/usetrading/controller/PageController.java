package com.satelite54.usetrading.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.satelite54.usetrading.model.board.dto.BoardDTO;
import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.service.board.BoardPage;
import com.satelite54.usetrading.service.board.IBoardService;
import com.satelite54.usetrading.service.product.IProductService;

@Controller
public class PageController {
	
	IBoardService boardService;
	IProductService productService;
	
	@Autowired
	public PageController(IBoardService boardService, IProductService productService) {
		this.boardService = boardService;
		this.productService = productService;
	}
	
	@RequestMapping(value = "/Main")
	private String getPopularProduct(Model model) {
		Date date = new Date(System.currentTimeMillis());
		List<ProductDTO> productPopulLists = productService.getPopularityItems(date);
		model.addAttribute("productPopulLists", productPopulLists);
		return "main";
	}
	
	@RequestMapping(value = {"/Board"}, method = RequestMethod.GET)
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
}
