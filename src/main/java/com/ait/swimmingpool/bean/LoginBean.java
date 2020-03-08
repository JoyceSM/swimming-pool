package com.ait.swimmingpool.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginBean {
	private String username;
	
	private String password;
	
	private int accessId;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccessId() {
		return accessId;
	}

	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}
}
