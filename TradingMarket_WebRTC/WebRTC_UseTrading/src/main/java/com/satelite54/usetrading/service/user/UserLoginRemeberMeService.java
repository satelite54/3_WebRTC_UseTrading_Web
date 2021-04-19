package com.satelite54.usetrading.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;

public class UserLoginRemeberMeService extends AbstractRememberMeServices {
	
	protected UserLoginRemeberMeService(String key, UserDetailsService userDetailsService) {
		super(key, userDetailsService);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	ConnectionUserData connUserData;
	
	@Override
	protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication successfulAuthentication) {
		// TODO Auto-generated method stub
		connUserData.addConnUser(successfulAuthentication.getName());
	}
	
	@Override
	/* �ڵ� �α��� ���� - ��Ű ��ȿ�� ���� �� ����� ���� ��ü ���� */
	protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request,
			HttpServletResponse response) throws RememberMeAuthenticationException, UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// TODO Auto-generated method stub
		connUserData.disconnectUser(authentication.getName());
		
		//��Ű ����
		super.logout(request, response, authentication);
	}
}
