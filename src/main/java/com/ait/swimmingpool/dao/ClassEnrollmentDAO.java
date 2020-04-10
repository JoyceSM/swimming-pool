package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.ClassEnrollmentBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class ClassEnrollmentDAO {
	
	public List<ClassEnrollmentBean> findAll() {
		List<ClassEnrollmentBean> list = new ArrayList<ClassEnrollmentBean>();
		Connection c = null;
		String sql = "SELECT * FROM Class_Enrollment";
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

	protected ClassEnrollmentBean processRow(ResultSet rs) throws SQLException {
		ClassEnrollmentBean classEnrollment = new ClassEnrollmentBean();
		classEnrollment.setUserId(rs.getInt("user_id"));
		classEnrollment.setClassId(rs.getString("class_id"));
		classEnrollment.setPaymentId(rs.getInt("payment_id"));
		classEnrollment.setEnrollmentDate(rs.getString("enrollment_date"));
		classEnrollment.setSchoolName(rs.getString("school_name"));
		classEnrollment.setPrice(rs.getDouble("price"));
		return classEnrollment;
	}

	public ClassEnrollmentBean create(ClassEnrollmentBean enrollment) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement("INSERT INTO Class_Enrollment"
					+ " (user_id, class_id, payment_id, enrollment_date, school_name, price)"
					+ " VALUES (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, enrollment.getUserId());
			ps.setString(2, enrollment.getClassId());
			ps.setInt(3, enrollment.getPaymentId());
			ps.setString(4, enrollment.getEnrollmentDate());
			ps.setString(5, enrollment.getSchoolName());
			ps.setDouble(6, enrollment.getPrice());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return enrollment;
	}

	public ClassEnrollmentBean update(ClassEnrollmentBean enrollment) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE Class_Enrollment SET class_id = ?, payment_id = ?, enrollment_date = ?, school_name = ?, price = ? "
							+ "WHERE user_id = ?");
			ps.setString(1, enrollment.getClassId());
			ps.setInt(2, enrollment.getPaymentId());
			ps.setString(3, enrollment.getEnrollmentDate());
			ps.setString(5, enrollment.getSchoolName());
			ps.setDouble(6, enrollment.getPrice());
			ps.setInt(7, enrollment.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return enrollment;
	}

	public boolean remove(int id) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM Class_Enrollment WHERE user_id=?");
			ps.setInt(1, id);
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
