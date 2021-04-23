package com.satelite54.usetrading.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.satelite54.usetrading.model.board.dto.BoardDTO;
import com.satelite54.usetrading.service.board.BoardPage;
import com.satelite54.usetrading.service.board.IBoardService;
import com.satelite54.usetrading.service.product.IProductService;

@RequestMapping(value = "/board")
@Controller
public class BoardController {
	
	IBoardService boardService;
	IProductService productService;
	
	@Autowired
	public BoardController(IBoardService boardService, IProductService productService) {
		this.boardService = boardService;
		this.productService = productService;
	}
	
	// 보드 제작
	// [KTH : 2021. 3. 31. 오후 1:59:15]
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	private String getBoard(Model model,
			@RequestParam(value = "page", defaultValue = "1") String curPage,
			@RequestParam(value = "boardsearch", defaultValue = "") String search
			,@RequestParam(value = "pageSize" , defaultValue = "10") String Param_PageSize
			) {
		int pageNum = Integer.parseInt(curPage);
		int startBlockNum = 1;
		int endBlockNum = 1;
		int pageSize = Integer.parseInt(Param_PageSize);
		if(pageNum == 1) {
		    	startBlockNum = 0;
			endBlockNum = pageNum * pageSize-1;
		} else {
			startBlockNum = pageNum * pageSize - pageSize;
			endBlockNum = pageSize * (pageNum + 1) - 1 - pageSize;
		}
		BoardPage page = new BoardPage();
		int PageNum = Integer.parseInt(curPage);
		page.setPageNo(PageNum);
		page.setPageSize(pageSize);//pageSize
		List<BoardDTO> boardList;
		if(search != "") {
			boardList = boardService.getSearchBoardPageList(startBlockNum, endBlockNum, search);
			page.setTotalCount(boardService.getTotalBoardCnt(search));
		} else {
			boardList = boardService.getBoardPageList(startBlockNum, endBlockNum, search);
			page.setTotalCount(boardService.getTotalBoardCnt());
		}
		
		model.addAttribute("Page", page);
		model.addAttribute("pageSize", Param_PageSize);
		model.addAttribute("BoardList", boardList);
		model.addAttribute("searchtext", search);
		return "/community/community";
	}
	
	@RequestMapping(value ="/getboardView")
	public String getBoardView(@RequestParam String BNum, Model model) {
		BoardDTO boardDTO = boardService.getBoardView(BNum);
		model.addAttribute("boardDTO", boardDTO);
		boolean boardRead = true;
		model.addAttribute("boardRead", boardRead);
		return "/community/communityReadAndUpdate";
	}
	
	@RequestMapping(value ="/setboardUpdate", method = RequestMethod.POST)
	public String setBoardUpdate(@RequestParam (value ="BTitle",defaultValue = "") String BTitle,
								@RequestParam (value ="BContent",defaultValue = "") String BContent,
								@RequestParam (value ="BNum") String BNum,
								Principal principal,
								Model model) {
		int updateResult = boardService.setBoardUpdate(BTitle, BContent, Integer.parseInt(BNum), principal.getName());
		
	 	if(updateResult == 1) {
	 		model.addAttribute("msg", "게시글 업데이트 완료");
	 		model.addAttribute("url", "/usetrading/board/getboardView?BNum=" + BNum);
	 	} else if(updateResult == 0) {
	 		model.addAttribute("msg", "게시글 업데이트 실패");
	 		model.addAttribute("url", "/usetrading/board/getboardView?BNum=" + BNum);
	 	}
		return "/scriptHtml/alert";
	}
	
	@RequestMapping(value = "/goBoardUpdate", method = RequestMethod.POST)
	private ModelAndView goBoardUpdate(Model model,
										@RequestParam(value ="BTitle") String BTitle,
										@RequestParam(value ="BContent") String BContent,
										@RequestParam(value ="BNum") String BNum,
										@RequestParam(value ="id") String id,
										Principal principal) {
		ModelAndView modelAndView =  new ModelAndView("community/communityReadAndUpdate.jsp?boardUpdate=1");
		if(id.equals(principal.getName())) {
			modelAndView.addObject("BTitle" , BTitle);
			modelAndView.addObject("BContent", BContent);
			modelAndView.addObject("id", id);
			modelAndView.addObject("BNum", BNum);
		} else {
			modelAndView.setViewName("/scriptHtml/alert");
			modelAndView.addObject("msg", "자기 자신의 글만 수정 가능합니다.");
			modelAndView.addObject("url", "/usetrading/product/popularity");
		}
		return modelAndView;
	}
}
