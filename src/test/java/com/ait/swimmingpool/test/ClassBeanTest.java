package com.ait.swimmingpool.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.swimmingpool.bean.ClassBean;

public class ClassBeanTest {
	
	ClassBean classBean;

	@Before
	public void setUp() throws Exception {
		classBean = new ClassBean();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimetable() {
		
	}
	
	@Test
	public void testClassId() {
		classBean.setClassId("A123");
		assertEquals("A123", classBean.getClassId());
	}
	
	@Test
	public void testPrice() {
		classBean.setPrice(10.0);
		assertEquals(10.0, classBean.getPrice(), 0);
	}
	
	@Test
	public void testCapacity() {
		classBean.setCapacity(10);
		assertEquals(10, classBean.getCapacity());
	}
	
	@Test
	public void testStartDate() {
		
	}
	
	@Test
	public void testEndDate() {
		
	}
	
	@Test
	public void testInstructor() {
		classBean.setInstructor("Joe");
		assertEquals("Joe", classBean.getInstructor());
	}

}
