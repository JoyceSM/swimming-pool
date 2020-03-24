package com.ait.swimmingpool.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.swimmingpool.bean.UserBean;

public class UserBeanTest {
	
	UserBean user;

	@Before
	public void setUp() throws Exception {
		user = new UserBean();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserId() {
		user.setUserId(1);
		assertEquals(1, user.getUserId());
	}
	
	@Test
	public void testFullName() {
		user.setFullName("John Doe");
		assertEquals("John Doe", user.getFullName());
	}
	
	@Test
	public void testGender() {
		user.setGender("Male");
		assertEquals("Male", user.getGender());
	}
	
	@Test
	public void testDateOfBirth() {
		
	}
	
	@Test
	public void testMembership() {
		user.setMembership("full");
		assertEquals("full", user.getMembership());
	}
	
	@Test
	public void testEmail() {
		user.setEmail("email@email.com");
		assertEquals("email@email.com", user.getEmail());
	}
	
	@Test
	public void testTelephone() {
		user.setTelephone("123456");
		assertEquals("123456", user.getTelephone());
	}
	
	@Test
	public void testAddress() {
		user.setAddress("Athlone");
		assertEquals("Athlone", user.getAddress());
	}
	
	@Test
	public void testCity() {
		user.setCity("Athlone");
		assertEquals("Athlone", user.getCity());
	}
	
	@Test
	public void testLoginBean() {
		
	}

}
