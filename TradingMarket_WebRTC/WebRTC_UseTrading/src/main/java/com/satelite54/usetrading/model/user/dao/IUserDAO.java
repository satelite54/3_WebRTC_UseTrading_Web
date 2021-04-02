package com.satelite54.usetrading.model.user.dao;

import java.sql.Date;
import java.util.List;

import com.satelite54.usetrading.model.product.dto.ProductDTO;

public interface IUserDAO {
	public int getidentify(String id, String pw);
}
