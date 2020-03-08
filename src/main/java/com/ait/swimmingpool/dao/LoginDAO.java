package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ait.swimmingpool.bean.LoginBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class LoginDAO {

	public LoginBean findByUsername(String username) {
		LoginBean login = null;
		Connection c = null;
		String sql = "SELECT * FROM Login WHERE username = ?";
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				login = processRow(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return login;

	}

	protected LoginBean processRow(ResultSet rs) throws SQLException {
		LoginBean login = new LoginBean();
		login.setUsername(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		login.setAccessId(rs.getInt("access_id"));
		return login;
	}
}
