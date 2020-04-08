package com.ait.swimmingpool.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.swimmingpool.bean.LoginBean;
import com.ait.swimmingpool.dao.LoginDAO;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class LoginDaoTest {

	private LoginDAO loginDao;
	private LoginBean loginBean;
	private Connection c;

	@Before
	public void init() throws ClassNotFoundException, SQLException {
		c = ConnectionHelper.getConnection();
		loginDao = new LoginDAO();
		loginBean = new LoginBean();
	}

	@After
	public void finalize() throws SQLException {
		c.close();
	}

	@Test
	public void testLogin() {
		LoginBean loginBean = loginDao.findByUsername("manager@snamh.com");
		assertEquals("123", loginBean.getPassword());
		assertEquals(1, loginBean.getAccessId());
		assertEquals("manager@snamh.com", loginBean.getUsername());

	}

}
