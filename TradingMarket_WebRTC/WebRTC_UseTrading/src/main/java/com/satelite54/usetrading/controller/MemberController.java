package com.satelite54.usetrading.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.satelite54.usetrading.model.user.dto.UserDTO;
import com.satelite54.usetrading.service.user.IUserService;

@Controller
@RequestMapping (value = "/member")
public class MemberController {
	IUserService userService;
	
	@Autowired(required=true)
	private HttpServletResponse response;
	
	@Autowired
	public MemberController(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping (value ="/login", method = RequestMethod.POST)
	private String loginAction(Model model, @RequestParam("id") String id, @RequestParam("pw") String pw) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printwriter = response.getWriter();
		userService.getidentify(id);
		return "/main";
	}
	
	@ResponseBody
	@RequestMapping (value="/loginfail", method = RequestMethod.POST)
	private String loginfailAction() {
		return "/page/goLogin";
	}
	
	@RequestMapping (value ="/join", method = RequestMethod.POST)
	private String joinAction(@ModelAttribute UserDTO userDTO) {
		
		System.out.println(userDTO.getName());
		System.out.println(userDTO.getEmail());
		System.out.println(userDTO.getPw());
		System.out.println(userDTO.getStreetAddress());
		System.out.println(userDTO.getLotAddress());
		
		int insertResult =  userService.RegisterUser(userDTO);
		
		return "/member/login";
	}
	@RequestMapping (value ="/modify")
	private String modifyAction(Model model) {
		
		return "";
	}
}
