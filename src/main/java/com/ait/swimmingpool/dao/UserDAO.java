package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.UserBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class UserDAO {
	
	public UserBean findByUsername(String username) {
		UserBean user = new UserBean();
		Connection c = null;
		String sql = "SELECT * FROM User where email_address = ?";
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = processRow(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return user;
	}
	
	
	public List<UserBean> findAll() {
		List<UserBean> list = new ArrayList<UserBean>();
		Connection c = null;
		String sql = "SELECT * FROM User ORDER BY user_id";
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
		user.setUserId(rs.getInt("user_id"));
		user.setFullName(rs.getString("full_name"));
		user.setGender(rs.getString("gender"));
		user.setDateOfBirth(rs.getDate("date_of_birth"));
		user.setMembership(rs.getBoolean("membership"));
		user.setEmail(rs.getString("email_address"));
		user.setTelephone(rs.getString("phone"));
		user.setAddress(rs.getString("address"));
		user.setCity(rs.getString("city"));
		return user;
	}

	public UserBean create(UserBean user) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement("INSERT INTO User"
					+ " (full_name, gender, date_of_birth, membership, email_address, phone, address, city)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)", new String[] { "user_id" });
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getGender());
			ps.setDate(3, new Date(user.getDateOfBirth().getTime()));
			ps.setBoolean(4, user.getMembership());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getTelephone());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getCity());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this value must be
			// returned
			int id = rs.getInt(1);
			user.setUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return user;
	}
}
