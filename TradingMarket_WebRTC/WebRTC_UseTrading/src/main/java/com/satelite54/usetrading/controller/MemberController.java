package com.satelite54.usetrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.satelite54.usetrading.service.user.IUserService;
import com.satelite54.usetrading.service.user.UserServiceImpl;

@Controller
@RequestMapping (value = "/member")
public class MemberController {
	IUserService userService;

	@Autowired
	public MemberController(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping (value ="/login", method = RequestMethod.POST)
	private String loginAction(Model model, @RequestParam("id") String id, @RequestParam("pw") String pw) {
		if(userService.getidentify(id, pw) == 1) {
			// 로그인 성공
			model.addAttribute("identified", 1);
			return "/main";
		} else {
			// 로그인 실패
			model.addAttribute("identified", 0);
			return "/member/login";
		}
	}
	@RequestMapping (value ="/join")
	private String joinAction(Model model) {
		
		return "";
	}
	@RequestMapping (value ="/modify")
	private String modifyAction(Model model) {
		
		return "";
	}
}
