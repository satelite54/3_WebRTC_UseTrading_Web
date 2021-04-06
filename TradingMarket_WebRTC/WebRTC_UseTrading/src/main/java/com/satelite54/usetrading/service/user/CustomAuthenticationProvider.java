
package com.satelite54.usetrading.service.user;

import javax.inject.Inject;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.user.dto.UserDTO;


// ��������
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Inject
	private UserDetailsService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        	//����� �Է� ��
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
