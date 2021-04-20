package com.satelite54.usetrading.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.user.dto.UserDTO;

@Service
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
  //로그인 성공시 필요한 작업 추가
    
	ConnectionUserData connUserData;
	
	@Autowired
	public AuthenticationSuccessHandler(ConnectionUserData connUserData) {
		this.connUserData = connUserData;
	}
	
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		UserDTO userDTO = (UserDTO) authentication.getPrincipal();
		connUserData.addConnUser(userDTO.getEmail());
        super.onAuthenticationSuccess(request, response, authentication);
    }
}