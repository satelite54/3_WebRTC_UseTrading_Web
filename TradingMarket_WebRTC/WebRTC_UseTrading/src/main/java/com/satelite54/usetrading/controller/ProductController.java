package com.satelite54.usetrading.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.service.board.IBoardService;
import com.satelite54.usetrading.service.product.IProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	IBoardService boardService;
	IProductService productService;
	
	@Autowired
	public ProductController(IBoardService boardService, IProductService productService) {
		this.boardService = boardService;
		this.productService = productService;
	}
	
	// �α��ǰ ��������
	// [KTH : 2021. 3. 31. ���� 12:39:34]
	@RequestMapping(value = "/popularity")
	private String getPopularity(Model model) {
		Date date = new Date(System.currentTimeMillis());
		List<ProductDTO> productPopulLists = productService.getPopularityItems(date);
		model.addAttribute("productPopulLists", productPopulLists);
		return "main";
	}
	
	// �˻���ǰ ��������
	// [KTH : 2021. 3. 31. ���� 12:40:19]
	@RequestMapping(value = "/search") // 
	private String getSearch(Model model) {
		
		return "";
	}
	
	// ���� �ø� ��ǰ ��������
	// [KTH : 2021. 3. 31. ���� 12:40:43]
	@RequestMapping(value = "/myproduct")
	private String getMyProduct(Model model) {
		
		return "";
	}
}
