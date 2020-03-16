package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.TimetableBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;
import com.ait.wine.Wine;

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
		timetable.setClassId(rs.getInt("class_id"));
		timetable.setDayOfTheWeek(rs.getString("day_of_week"));
		timetable.setClassTime(rs.getInt("time"));
		return timetable;
	}
	
	public TimetableBean create(TimetableBean timetable) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement("INSERT INTO timetable" +
			" (day_of_week, time)" +
			" VALUES (?, ?)",
			new String[] { "class_id" });
			ps.setString(1, timetable.getDayOfTheWeek());
			ps.setInt(2, timetable.getClassTime());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this value must be returned
			int id = rs.getInt(1);
			timetable.setClassId(id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
		return timetable;
	}
	
	public TimetableBean update(TimetableBean timetable) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE Timetable SET day_of_week = ?, time = ? " +
			"WHERE class_id = ?");
			ps.setString(1, timetable.getDayOfTheWeek());
			ps.setInt(2, timetable.getClassTime());
			ps.setInt(3, timetable.getClassId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
		return timetable;
	}
	
	public boolean remove(int id) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM Timetable WHERE class_id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count == 1;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
	}
}
