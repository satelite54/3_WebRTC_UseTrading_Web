
package com.satelite54.usetrading.service.user;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.satelite54.usetrading.model.user.dao.UserDAOImpl;
import com.satelite54.usetrading.model.user.dto.UserDTO;

public class CustomUserDetailsService implements UserDetailsService{

	@Inject
	private UserDAOImpl UserDAO;
	
	@Override
	public UserDetails loadUserByUsername(String id) 
    						throws UsernameNotFoundException {
                            	
		UserDTO user = UserDAO.getidentify(id);
		
		if(user == null) {
			throw new UsernameNotFoundException(id);
		}
		return user;
	}
}
