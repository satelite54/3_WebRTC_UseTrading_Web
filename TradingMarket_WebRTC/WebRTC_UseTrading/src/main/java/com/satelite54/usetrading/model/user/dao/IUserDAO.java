package com.satelite54.usetrading.model.user.dao;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.user.dto.UserDTO;

public interface IUserDAO {
	public UserDTO getidentify(String id);
}
