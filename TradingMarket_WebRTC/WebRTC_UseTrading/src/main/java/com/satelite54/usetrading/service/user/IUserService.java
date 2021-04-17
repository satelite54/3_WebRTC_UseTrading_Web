package com.satelite54.usetrading.service.user;

import com.satelite54.usetrading.model.user.dto.UserDTO;

public interface IUserService {
	// [KTH : 2021. 4. 6. 오전 10:20:09]
	UserDTO getidentify(String id);
	
	int registerUser(UserDTO userInfo);
	int updateUser(UserDTO userInfo);
}
