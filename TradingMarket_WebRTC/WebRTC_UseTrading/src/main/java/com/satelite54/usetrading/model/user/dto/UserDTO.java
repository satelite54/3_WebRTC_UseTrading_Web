
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
	
	//������ ���� �ִ� ���� ��� ����
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roleGrant = "ROLE_" + admin;
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(roleGrant));
		return auth;
	}
	
	//������ ���� ����
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//������ ������� �ʾҴ����� ����
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//������ �н����尡 ������� �ʾҴ°�?
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//������ ��밡���Ѱ�?
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
