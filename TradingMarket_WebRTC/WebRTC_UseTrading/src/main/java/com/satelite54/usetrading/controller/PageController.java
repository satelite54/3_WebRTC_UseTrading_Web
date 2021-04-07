package com.satelite54.usetrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "/member/login";
	}
	
	@RequestMapping(value = "/goJoin")
	private String goJoin() {
		return "/member/join";
	}
}
