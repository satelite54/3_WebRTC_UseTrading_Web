package com.satelite54.usetrading.service.user;

import java.util.Vector;

import org.springframework.stereotype.Service;

public class ConnectionUserData {
	
	Vector<String> ConnUserlist;
	
	public ConnectionUserData() {
		this.ConnUserlist = new Vector<String>();
	}
	
	public boolean addConnUser(String email) {
		for(int i = 0; i < ConnUserlist.size(); i++) {
			if(ConnUserlist.get(i).equals(email)) {
				return false;
			}
		}
		ConnUserlist.add(email);
		return true;
	}
	
	public String getConnUser(String email) {
		for(String userEmail : ConnUserlist) {
			if(userEmail.equals(email)) {
				return email;
			}
		}
		return "none";
	}
	
	public boolean disconnectUser(String email) {
		for(int i = 0; i < ConnUserlist.size(); i++) {
			if(ConnUserlist.get(i).equals(email)) {
				ConnUserlist.remove(i);
				return true;
			}
		}
		return false;
	}
}
