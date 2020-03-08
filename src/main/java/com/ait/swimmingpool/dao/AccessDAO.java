package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.AccessBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class AccessDAO {
	public List<AccessBean> findAll() {
		List<AccessBean> list = new ArrayList<AccessBean>();
		Connection c = null;
		String sql = "SELECT * FROM Access_Type";
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
	
	protected AccessBean processRow(ResultSet rs) throws SQLException {
		AccessBean access = new AccessBean();
		access.setAccessId(rs.getInt("access_id"));
		access.setFunctionType(rs.getString("function_type"));
		return access;
	}

}
