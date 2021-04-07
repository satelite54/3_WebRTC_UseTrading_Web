package com.satelite54.usetrading.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.user.dao.UserDAOImpl;
import com.satelite54.usetrading.model.user.dto.UserDTO;

@Service
public class UserServiceImpl implements IUserService{
	
	private UserDAOImpl userDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public UserDTO getidentify(String id) {
		UserDTO user = userDAO.getidentify(id);
		
		if(user == null) {
			throw new UsernameNotFoundException(id);
		}
		return user;
	}
	
	@Override
	public int RegisterUser(UserDTO userInfo) {
		String endcodedPassword = bcryptPasswordEncoder.encode(userInfo.getPassword());
		userInfo.setPw(endcodedPassword);
		userInfo.setAdmin("USER");
		int insertResult =  userDAO.RegisterUser(userInfo);
		return insertResult;
	}
}
