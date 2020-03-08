package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.TimetableBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class TimetableDAO {
	public List<TimetableBean> findAll() {
		List<TimetableBean> list = new ArrayList<TimetableBean>();
		Connection c = null;
		String sql = "SELECT * FROM Timetable";
		try {
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;
	}
	
	protected TimetableBean processRow(ResultSet rs) throws SQLException {
		TimetableBean timetable = new TimetableBean();
		timetable.setClassId(rs.getString("class_id"));
		timetable.setDayOfTheWeek(rs.getString("day_of_week"));
		timetable.setClassTime(rs.getInt("time"));
		return timetable;
	}
}
