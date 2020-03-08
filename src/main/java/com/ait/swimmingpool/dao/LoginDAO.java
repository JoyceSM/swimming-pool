package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.LoginBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class LoginDAO {
	public List<LoginBean> findAll() {
		List<LoginBean> list = new ArrayList<LoginBean>();
		Connection c = null;
		String sql = "SELECT * FROM Login";
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
	
	protected LoginBean processRow(ResultSet rs) throws SQLException {
		LoginBean login = new LoginBean();
		login.setUsername(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		login.setAccessId(rs.getInt("access_id"));
		return login;
	}
}
