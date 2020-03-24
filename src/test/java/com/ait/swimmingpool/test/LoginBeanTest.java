package com.ait.swimmingpool.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.swimmingpool.bean.LoginBean;

public class LoginBeanTest {
	
	LoginBean login;

	@Before
	public void setUp() throws Exception {
		login = new LoginBean();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUsername() {
		login.setUsername("user");
		assertEquals("user", login.getUsername());
	}
	
	@Test
	public void testPassword() {
		login.setPassword("pass");
		assertEquals("pass", login.getPassword());
	}
	
	@Test
	public void testAccessId() {
		login.setAccessId(123);
		assertEquals(123, login.getAccessId());
	}

}
