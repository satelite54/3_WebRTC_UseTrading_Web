package com.satelite54.usetrading.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.satelite54.usetrading.model.user.dto.UserDTO;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends
		SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
	
	ConnectionUserData connUserData;

	@Autowired
	public CustomLogoutSuccessHandler(ConnectionUserData connUserData) {
		this.connUserData = connUserData;
	}
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		UserDTO userDTO = (UserDTO) authentication.getPrincipal();
		connUserData.disconnectUser(userDTO.getEmail());
		
		super.onLogoutSuccess(request, response, authentication);
	}
}