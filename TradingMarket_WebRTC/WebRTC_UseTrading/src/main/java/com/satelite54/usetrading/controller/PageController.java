package com.satelite54.usetrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value = "/goUpdate")
	private String goUpdate() {
		return "/member/update";
	}
	@RequestMapping(value = "/goProductAdd")
	private String goProductAdd() {
		return "/product/addproduct";
	}
}
