package com.satelite54.usetrading.controller;

import java.lang.reflect.Field;
import java.security.Principal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.satelite54.RTC.model.Room;
import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.product.dto.ProductHeartDTO;
import com.satelite54.usetrading.model.product.dto.ProductHeartResult;
import com.satelite54.usetrading.model.user.dto.UserDTO;
import com.satelite54.usetrading.service.board.IBoardService;
import com.satelite54.usetrading.service.product.IProductService;
import com.satelite54.usetrading.service.user.ConnectionUserData;
import org.json.simple.JSONObject;

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
		
		// 모든 상품 리스트 대표 사진 세팅
		// [KTH : 2021. 4. 19. 오전 9:55:10]
		for(int i = 0; i < productlist.size(); i++) {
			String[] TotalPath = productService.splitPath(productlist.get(i).getPPhotoPath());
			String firstPath = TotalPath[0];
			productlist.get(i).setPPhotoPath(firstPath);
		}
		
		ModelAndView modelAndView = new ModelAndView("/product/searchresult");
		modelAndView.addObject("products", productlist);
		return modelAndView;
	}
	
	@RequestMapping(value = "/getproduct/{pNum}")
	private ModelAndView getproduct(@PathVariable String pNum, Principal principal) {
		productService.updateView(pNum);
		ProductDTO productDTO = productService.getsearchproducts(pNum).get(0);
		String bol = "";
		productDTO.setPHeart(productService.getproductheartcount(pNum, "1"));
		if(connUserData.getConnUser(productDTO.getPName()).equals(principal.getName())) {
			bol = "true";
		}

		String[] path = productService.splitPath(productDTO.getPPhotoPath());

		ModelAndView modelAndView = new ModelAndView("/product/viewproduct");
		modelAndView.addObject("product", productDTO);
		modelAndView.addObject("photopaths", productService.splitPath(productDTO.getPPhotoPath()));
		modelAndView.addObject("getConnect", bol);
		return modelAndView;
	}
	
	@RequestMapping(value = "/addheart" , method = RequestMethod.POST)
	private @ResponseBody Map<String, Object> ajaxheart(
			@RequestParam(value = "pNum") String pNum,
			@RequestParam(value = "uNum") String nNum) {
		
		ProductHeartResult result = new ProductHeartResult();
//		dto.getUNum()
//		dto.getNbool()
//		dto.getNHeart()
//		dto.getPNum()
		String nbool = productService.getboolheart(pNum);
		productService.productheartInsertOrUpdate(pNum, nNum, nbool);
		result.setTotalheart(productService.getproductheartcount(pNum, nbool));
		result.setNbool(productService.getboolheart(pNum));
		ProductDTO productDTO = productService.getsearchproducts(pNum).get(0);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("TotalNum", result.getTotalheart());
		paramMap.put("NBool", result.getNbool());
		
		return paramMap;
	}
}
