package com.ait.swimmingpool.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TimetableBean {
	private String classId;

	private String dayOfTheWeek;

	private int classTime;

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public int getClassTime() {
		return classTime;
	}

	public void setClassTime(int classTime) {
		this.classTime = classTime;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
}