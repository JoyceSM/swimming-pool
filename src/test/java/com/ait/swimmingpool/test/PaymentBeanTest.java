package com.ait.swimmingpool.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.swimmingpool.bean.PaymentBean;

public class PaymentBeanTest {
	
	PaymentBean payment;

	@Before
	public void setUp() throws Exception {
		payment = new PaymentBean();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPaymentId() {
		payment.setPaymentId(12345);
		assertEquals(12345, payment.getPaymentId());
	}
	
	@Test
	public void testUserId() {
		payment.setUserId("A123");
		assertEquals("A123", payment.getUserId());
	}
	
	@Test
	public void testAmount() {
		payment.setAmount(100.0);
		assertEquals(100.0, payment.getAmount(), 0);
	}
	
	@Test
	public void testPaymentDate() {
		payment.setPaymentId(12345);
		assertEquals(12345, payment.getPaymentId());
	}

}
