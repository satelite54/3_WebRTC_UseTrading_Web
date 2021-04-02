package com.satelite54.usetrading.service.user;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.product.dto.ProductDTO;
import com.satelite54.usetrading.model.user.dto.UserDTO;

public interface IUserService {
	public int getidentify(String id, String pw);
}
