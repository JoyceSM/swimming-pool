package com.ait.swimmingpool.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClassEnrollmentBean {
	private int userId;
	
	private String classId;
	
	private int paymentId;
	
	private String enrollmentDate;
	
	private String schoolName;
	
	private double price;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}
