
package com.satelite54.usetrading.model.user.dto;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Repository
@Setter
@Getter
public class UserDTO {
	private int userNum;
	private String userId;
	private String userPassword;
	private int userAdmin;
}
