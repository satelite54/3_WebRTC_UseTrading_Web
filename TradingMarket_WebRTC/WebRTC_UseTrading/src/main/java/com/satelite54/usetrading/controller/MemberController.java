package com.satelite54.usetrading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/member")
public class MemberController {
	
	@RequestMapping (value ="/login")
	private String loginAction(Model model) {
		
		return "";
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
