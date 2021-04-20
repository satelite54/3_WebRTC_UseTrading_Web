package com.satelite54.usetrading.controller;

import java.security.Principal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import com.satelite54.usetrading.model.user.dto.UserDTO;
import com.satelite54.usetrading.service.board.IBoardService;
import com.satelite54.usetrading.service.product.IProductService;
import com.satelite54.usetrading.service.user.ConnectionUserData;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	IBoardService boardService;
	IProductService productService;
	ConnectionUserData connUserData;
	
	@Autowired
	public ProductController(IBoardService boardService, IProductService productService, ConnectionUserData connUserData) {
		this.boardService = boardService;
		this.productService = productService;
		this.connUserData = connUserData;
	}
	
	// 인기상품 가져오기
	// [KTH : 2021. 3. 31. 오후 12:39:34]
	@RequestMapping(value = "/popularity")
	private String getPopularity(Model model) {
		Date date = new Date(System.currentTimeMillis());
		List<ProductDTO> productPopulLists = productService.getPopularityItems(date);
		model.addAttribute("productPopulLists", productPopulLists);
		return "main";
	}
	
	// 상품 등록
	// [KTH : 2021. 3. 31. 오후 12:40:43]
	@RequestMapping(value = "/addproduct")
	private String getMyProduct(@ModelAttribute ProductDTO productDTO, Model model,
			@RequestParam(required=false) List<MultipartFile> Photos) {
	 	int insertResult = productService.setItem(productDTO, Photos);
	 		
	 	if(insertResult == 1) {
	 		model.addAttribute("msg", "상품 등록 완료");
	 		model.addAttribute("url", "/usetrading/page/goProductAdd");
	 	} else if(insertResult == 0) {
	 		model.addAttribute("msg", "상품 등록 실패");
	 		model.addAttribute("url", "/usetrading/page/goProductAdd");
	 	}
		return "/scriptHtml/alert";
	}
	
	// 상품 검색 결과
	// [KTH : 2021. 4. 19. 오전 9:55:10]
	@RequestMapping(value = "/searchresult")
	private ModelAndView getSearchResult(@RequestParam(value = "search", defaultValue = "") String search) {
		List<ProductDTO> productlist = productService.getsearchproducts(search);
		
		ModelAndView modelAndView = new ModelAndView("/product/searchresult");
		modelAndView.addObject("products", productlist);
		return modelAndView;
	}
	
	@RequestMapping(value = "/getproduct/{pNum}")
	private ModelAndView getproduct(@PathVariable String pNum, Principal principal) {
		ProductDTO productDTO = productService.getsearchproducts(pNum).get(0);
		String bol = "";
		String pname = productDTO.getPName();
		String priGetNaame = principal.getName();
		String getConnUser = connUserData.getConnUser("taehune94@gmail.com");
		if(connUserData.getConnUser(productDTO.getPName()).equals(principal.getName())) {
			bol = "true";
		}
		
		ModelAndView modelAndView = new ModelAndView("/product/viewproduct");
		modelAndView.addObject("product", productDTO);
		modelAndView.addObject("photopaths", productService.splitPath(productDTO.getPPhotoPath()));
		modelAndView.addObject("getConnect", bol);
		return modelAndView;
	}
}
