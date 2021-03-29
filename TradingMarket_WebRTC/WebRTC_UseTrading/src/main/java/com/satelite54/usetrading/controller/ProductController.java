package com.satelite54.usetrading.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.service.product.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	IProductService productServ;
	
	@RequestMapping(value = "/MainAction")
	private String getPopularProduct(Model model) {
		Date date = new Date(System.currentTimeMillis());
		List<ProductDTO> productPopulLists = productServ.getPopularityItems(date);
		model.addAttribute("productPopulLists", productPopulLists);
		return "main";
	}
}
