package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
		newClass.setCapacity(rs.getInt("capacity"));
		newClass.setStartDate(rs.getDate("start_date"));
		newClass.setEndDate(rs.getDate("end_date"));
		newClass.setInstructor(rs.getString("instructor"));
		return newClass;
	}

	public ClassBean create(ClassBean addClass) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement(
					"INSERT INTO class " + "(class_id, class_name, price, capacity, start_date, end_date, instructor)"
							+ " VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, addClass.getClassId());
			ps.setString(2, addClass.getClassName());
			ps.setDouble(3, addClass.getPrice());
			ps.setDouble(4, addClass.getCapacity());
			ps.setDate(5, new Date(addClass.getStartDate().getTime()));
			ps.setDate(6, new Date(addClass.getEndDate().getTime()));
			ps.setString(7, addClass.getInstructor());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return addClass;

	}

	public boolean remove(String classId) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM class WHERE class_id=?");
			ps.setString(1, classId);
			int count = ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			ConnectionHelper.close(c);
		}
	}

	public ClassBean findById(String classId) {
		String sql = "SELECT * FROM class WHERE class_id = ? ";
		ClassBean cb = null;
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, classId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cb = processRow(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}

		return cb;
	}

	public ClassBean update(ClassBean classObj) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE class SET class_name=?, price=?, capacity=?, start_date=?, end_date=?, instructor=? WHERE class_id=?");
			ps.setString(1, classObj.getClassName());
			ps.setDouble(2, classObj.getPrice());
			ps.setInt(3, classObj.getCapacity());
			ps.setDate(4, new Date(classObj.getStartDate().getTime()));
			ps.setDate(5, new Date(classObj.getEndDate().getTime()));
			ps.setString(6, classObj.getInstructor());
			ps.setString(7, classObj.getClassId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			ConnectionHelper.close(c);
		}
		return classObj;
	}
			
}
