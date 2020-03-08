package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.ClassBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class ClassDAO {
	public List<ClassBean> findAll() {
		List<ClassBean> list = new ArrayList<ClassBean>();
		Connection c = null;
		String sql = "SELECT * FROM Class";
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
	
	protected ClassBean processRow(ResultSet rs) throws SQLException {
		ClassBean newClass = new ClassBean();
		newClass.setClassId(rs.getString("class_id"));
		newClass.setClassName(rs.getString("class_name"));
		newClass.setPrice(rs.getDouble("price"));
		newClass.setCapacity(rs.getDouble("capacity"));
		newClass.setStartDate(rs.getString("start_date"));
		newClass.setEndDate(rs.getString("end_date"));
		newClass.setInstructor(rs.getString("instructor"));
		return newClass;
	}
}
