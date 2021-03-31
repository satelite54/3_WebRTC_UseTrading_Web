package com.satelite54.usetrading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/webrtc")
public class WebRTCController {
	
	@RequestMapping(value = "/conPeerToPeer")
	private String getPeer(Model model) {
		
		return "";
	}
	
	@RequestMapping(value = "/conCheck")
	private String getConState(Model model) {
		
		return "";
	}
}
