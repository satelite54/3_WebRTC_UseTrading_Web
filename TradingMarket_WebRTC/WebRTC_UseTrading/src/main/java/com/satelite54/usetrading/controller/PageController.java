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
@RequestMapping(value = "/page")
public class PageController {
	
	IBoardService boardService;
	IProductService productService;
	
	@Autowired
	public PageController(IBoardService boardService, IProductService productService) {
		this.boardService = boardService;
		this.productService = productService;
	}
	
	@RequestMapping(value = "/goLogin")
	private String goLogin() {
		return "/myinfo/login";
	}
}
