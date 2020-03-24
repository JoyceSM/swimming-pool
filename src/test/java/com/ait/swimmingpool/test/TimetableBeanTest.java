package com.ait.swimmingpool.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ait.swimmingpool.bean.TimetableBean;

public class TimetableBeanTest {
	
	TimetableBean timetable;

	@Before
	public void setUp() throws Exception {
		timetable = new TimetableBean();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClassId() {
		timetable.setClassId("A123");
		assertEquals("A123", timetable.getClassId());
	}
	
	@Test
	public void testDayOfTheWeek() {
		timetable.setDayOfTheWeek("Monday");
		assertEquals("Monday", timetable.getDayOfTheWeek());
	}
	
	@Test
	public void testClassTime() {
		timetable.setClassTime("1pm");
		assertEquals("1pm", timetable.getClassTime());
	}

}
