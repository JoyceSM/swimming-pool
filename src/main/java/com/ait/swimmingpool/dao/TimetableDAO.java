package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.ClassBean;
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
		timetable.setClassTime(rs.getString("class_time"));
		return timetable;
	}

	public TimetableBean create(TimetableBean timetable) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(
					"INSERT INTO timetable" + " (class_id, day_of_week, class_time)" + " VALUES (?, ?, ?)");
			ps.setString(1, timetable.getClassId());
			ps.setString(2, timetable.getDayOfTheWeek());
			ps.setString(3, timetable.getClassTime());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return timetable;
	}

	public List<TimetableBean> findById(String classId) {
		List<TimetableBean> list = new ArrayList<TimetableBean>();
		Connection c = null;
		String sql = "SELECT * FROM timetable WHERE class_id = ? ";
		TimetableBean tb = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, classId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processRow(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}

		return list;
	}

	public TimetableBean update(TimetableBean timetable) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c
					.prepareStatement("UPDATE Timetable SET day_of_week = ?, class_time = ? " + "WHERE class_id = ?");
			ps.setString(1, timetable.getClassId());
			ps.setString(2, timetable.getDayOfTheWeek());
			ps.setTime(2, Time.valueOf(timetable.getClassTime()));
			ps.setString(3, timetable.getClassId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return timetable;
	}

	public boolean remove(String classId) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM Timetable WHERE class_id=?");
			ps.setString(1, classId);
			int count = ps.executeUpdate();
			return count == 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
	}
}
