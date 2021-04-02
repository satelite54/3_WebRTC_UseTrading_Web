package com.satelite54.usetrading.service.user;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satelite54.usetrading.model.product.dao.ProductDAOImpl;
import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.user.dao.UserDAOImpl;

@Service
public class UserServiceImpl implements IUserService{
	
	private UserDAOImpl userDAO;
	
	@Autowired
	public UserServiceImpl(UserDAOImpl userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public int getidentify(String id, String pw) {
		if(userDAO.getidentify(id, pw) == 1) {
			return 1;
		}
		return 0;
	}
}
