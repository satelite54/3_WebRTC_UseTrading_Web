
package com.satelite54.usetrading.model.user.dto;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Repository
@Setter
@Getter
public class UserDTO {
	private int uNum;
	private String uId;
	private String uPassWord;
	private int uAdmin;
}
