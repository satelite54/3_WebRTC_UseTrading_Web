package com.satelite54.usetrading.service.user;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.product.dao.ProductDAOImpl;
import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.user.dao.UserDAOImpl;
import com.satelite54.usetrading.model.user.dto.UserDTO;

@Service
public class UserServiceImpl implements IUserService{
	
	private UserDAOImpl userDAO;
	
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
}
