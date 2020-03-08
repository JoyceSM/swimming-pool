package com.ait.swimmingpool.dao;

import java.sql.Connection;
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
		classEnrollment.setUserId(rs.getString("user_id"));
		classEnrollment.setClassId(rs.getString("class_id"));
		classEnrollment.setPaymentId(rs.getString("payment_id"));
		classEnrollment.setEnrollmentDate(rs.getString("enrollment_date"));
		classEnrollment.setSchoolName(rs.getString("school_name"));
		classEnrollment.setPrice(rs.getDouble("price"));
		return classEnrollment;
	}
}
