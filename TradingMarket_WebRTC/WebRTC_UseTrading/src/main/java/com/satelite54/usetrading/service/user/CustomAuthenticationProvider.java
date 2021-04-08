
package com.satelite54.usetrading.service.user;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.user.dto.UserDTO;


// 인증로직
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Inject
	private UserDetailsService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        	//사용자 입력 값
		String id = (String)authentication.getPrincipal();
		String pw = (String)authentication.getCredentials();
		
		UserDTO user = (UserDTO)service.loadUserByUsername(id);
		
		if(!encoder.matches(pw, user.getPassword())) {
            	throw new BadCredentialsException(id);
       	 }
		return new UsernamePasswordAuthenticationToken(user, user, user.getAuthorities());
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
//	private boolean matchPassword(String pw, String password) {
//		return pw.equals(password);
//	}
}
