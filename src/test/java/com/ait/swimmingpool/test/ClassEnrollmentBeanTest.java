package com.ait.swimmingpool.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.swimmingpool.bean.ClassEnrollmentBean;

public class ClassEnrollmentBeanTest {
	
	ClassEnrollmentBean classEnrollment;

	@Before
	public void setUp() throws Exception {
		classEnrollment = new ClassEnrollmentBean();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserId() {
		classEnrollment.setUserId(5);
		assertEquals(5, classEnrollment.getUserId());
	}
	
	@Test
	public void testClassId() {
		classEnrollment.setClassId("A123");
		assertEquals("A123", classEnrollment.getClassId());
	}
	
	@Test
	public void testPaymentId() {
		classEnrollment.setPaymentId("B100");
		assertEquals("B100", classEnrollment.getPaymentId());
	}
	
	@Test
	public void testEnrollmentDate() {
		classEnrollment.setEnrollmentDate("12345");
		assertEquals("12345", classEnrollment.getEnrollmentDate());
	}
	
	@Test
	public void testSchoolName() {
		classEnrollment.setSchoolName("New School");
		assertEquals("New School", classEnrollment.getSchoolName());
	}
	
	@Test
	public void testPrice() {
		classEnrollment.setPrice(10.0);
		assertEquals(10.0, classEnrollment.getPrice(), 0);
	}

}
