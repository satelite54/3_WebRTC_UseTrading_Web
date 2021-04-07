
package com.satelite54.usetrading.model.user.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Repository
@Setter
@Getter
public class UserDTO implements UserDetails {
	private int num;
	private String email;
	private String pw;
	private String admin;
	private String name;
	private String residentRegNum;
	private String zip;
	private String streetAddress;
	private String lotAddress;
	private String detailedAddress;
	private String buildingNumber;
	private String phoneNum;
	private Date birthDay;
	
	//계정이 갖고 있는 권한 목록 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roleGrant = "ROLE_" + admin;
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(roleGrant));
		return auth;
	}
	
	//계정의 만료 여부
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//계정이 잠겨있지 않았는지를 리턴
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//계정의 패스워드가 만료되지 않았는가?
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//계정이 사용가능한가?
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		return pw;
	}

	@Override
	public String getUsername() {
		return email;
	}
}
