package com.satelite54.usetrading.aop;

public class SampleAopBean { 
	private String message;
	
	public SampleAopBean() { 
		super(); 
	} 
	
	public SampleAopBean(String message) { 
		this.message = message; 
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println("message:[" + message + "]");
	}
}

