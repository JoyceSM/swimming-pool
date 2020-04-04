package com.ait.swimmingpool.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBean {
	private int userId;

	private String fullName;

	private String gender;

	private Date dateOfBirth;

	private boolean membership;

	private String email;

	private String telephone;

	private String address;

	private String city;

	private LoginBean credentials;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public boolean getMembership() {
		return membership;
	}

	public void setMembership(boolean membership) {
		this.membership = membership;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LoginBean getCredentials() {
		return credentials;
	}

	public void setCredentials(LoginBean credentials) {
		this.credentials = credentials;
	}
}
