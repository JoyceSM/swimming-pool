package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.ClassTimeBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class ClassTimeDAO {
	
	public List<ClassTimeBean> findByDayOfWeek(String day) {
		List<ClassTimeBean> list = new ArrayList<ClassTimeBean>();
		Connection c = null;
		String sql = "SELECT Class.class_id, Class.class_name, Timetable.day_of_week, Timetable.class_time " + 
				"FROM Class INNER JOIN Timetable ON Class.class_id = Timetable.class_id WHERE day_of_week = ? ORDER BY " + 
				"CASE	   WHEN day_of_week = 'Sunday' THEN 1" + 
				"          WHEN day_of_week = 'Monday' THEN 2" + 
				"          WHEN day_of_week = 'Tuesday' THEN 3" + 
				"          WHEN day_of_week = 'Wednesday' THEN 4" + 
				"          WHEN day_of_week = 'Thursday' THEN 5" + 
				"          WHEN day_of_week = 'Friday' THEN 6" + 
				"          WHEN day_of_week = 'Saturday' THEN 7" + 
				"     END ASC, class_time, class_name;";
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, day);
			ResultSet rs = ps.executeQuery();
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

	protected ClassTimeBean processRow(ResultSet rs) throws SQLException {
		ClassTimeBean time = new ClassTimeBean();
		time.setDayOfWeek(rs.getString("day_of_week"));
		time.setClassName(rs.getString("class_name"));
		time.setClassTime(rs.getString("class_time"));
		return time;
	}

}
