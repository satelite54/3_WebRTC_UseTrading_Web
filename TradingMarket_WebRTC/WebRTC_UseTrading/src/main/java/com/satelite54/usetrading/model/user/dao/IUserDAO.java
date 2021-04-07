package com.satelite54.usetrading.model.user.dao;

import com.satelite54.usetrading.model.user.dto.UserDTO;

public interface IUserDAO {
	public UserDTO getidentify(String id);
	int RegisterUser(UserDTO userInfo);
}
