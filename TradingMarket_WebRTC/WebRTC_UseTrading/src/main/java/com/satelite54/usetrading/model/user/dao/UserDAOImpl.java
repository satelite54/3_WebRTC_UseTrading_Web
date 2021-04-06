package com.satelite54.usetrading.model.user.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satelite54.usetrading.model.user.dto.UserDTO;

@Repository
public class UserDAOImpl implements IUserDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private UserDTO userDTO;
	
	@Autowired
	public UserDAOImpl(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	@Override
	public UserDTO getidentify(String id) {
		UserDTO userDTO = sqlSession.selectOne("getuser", id);
		return userDTO;
	}
	
}
