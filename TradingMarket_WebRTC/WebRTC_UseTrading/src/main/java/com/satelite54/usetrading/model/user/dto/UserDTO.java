
package com.satelite54.usetrading.model.user.dto;

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
	private int userNum;
	private String userId;
	private String userPassword;
	private String userAdmin;
	
	
	//������ ���� �ִ� ���� ��� ����
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(userAdmin));
		return auth;
	}
	
	//�н����� ����
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//������ �̸� ����
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//������ ���� ����
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//������ ������� �ʾҴ����� ����
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//������ �н����尡 ������� �ʾҴ°�?
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//������ ��밡���Ѱ�?
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
