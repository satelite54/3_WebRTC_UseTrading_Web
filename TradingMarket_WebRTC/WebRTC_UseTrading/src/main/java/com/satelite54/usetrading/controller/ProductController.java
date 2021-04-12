package com.satelite54.usetrading.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.satelite54.RTC.model.Room;
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
	
	// ��ǰ ���
	// [KTH : 2021. 3. 31. ���� 12:40:43]
	@RequestMapping(value = "/addproduct")
	private String getMyProduct(@ModelAttribute ProductDTO productDTO, Model model,
			@RequestParam(required=false) List<MultipartFile> Photos) {
	 	int insertResult = productService.setItem(productDTO, Photos);
	 		
	 	if(insertResult == 1) {
	 		model.addAttribute("msg", "��ǰ ��� �Ϸ�");
	 		model.addAttribute("url", "/usetrading/page/goProductAdd");
	 	} else if(insertResult == 0) {
	 		model.addAttribute("msg", "��ǰ ��� ����");
	 		model.addAttribute("url", "/usetrading/page/goProductAdd");
	 	}
		return "/scriptHtml/alert";
	}
}
