
package com.satelite54.usetrading.service.user;

import javax.inject.Inject;
import javax.naming.AuthenticationException;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.satelite54.usetrading.model.user.dto.UserDTO;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Inject
	private UserDetailsService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) {
        
        	//사용자 입력 값
		String id = (String)authentication.getPrincipal();
		String pw = (String)authentication.getCredentials();
		
		UserDTO user = (UserDTO)service.loadUserByUsername(id);
		
		if(!matchPassword(pw, user.getPassword())) {
            	throw new BadCredentialsException(id);
       	 }


		return new UsernamePasswordAuthenticationToken(id, pw, user.getAuthorities());
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	private boolean matchPassword(String pw, String password) {
		return pw.equals(password);
	}
}
