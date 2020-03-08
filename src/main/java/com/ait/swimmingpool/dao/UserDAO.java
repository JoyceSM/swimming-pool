package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.UserBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class UserDAO {
	public List<UserBean> findAll() {
		List<UserBean> list = new ArrayList<UserBean>();
		Connection c = null;
		String sql = "SELECT * FROM user ORDER BY user_id";
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
	
	protected UserBean processRow(ResultSet rs) throws SQLException {
		UserBean user = new UserBean();
		user.setUserId(rs.getInt("userId"));
		user.setFullName(rs.getString("fullName"));
		user.setGender(rs.getString("gender"));
		user.setDateOfBirth(rs.getString("dateOfBirth"));
		user.setMembership(rs.getString("membership"));
		user.setEmail(rs.getString("email"));
		user.setTelephone(rs.getString("telephone"));
		user.setAddress(rs.getString("address"));
		user.setCity(rs.getString("city"));
		return user;
	}
}
