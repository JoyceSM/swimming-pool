package com.ait.swimmingpool.bean;

public class ClassTimeBean {
	
	
	private String classId;
	
	private String dayOfWeek;
	
	private String classTime;
	
	private String className;

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public String getClassId() {
		return classId;
	}


}
