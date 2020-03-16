package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public AccessBean create(AccessBean access) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement("INSERT INTO Access_Type" +
			" (function_type)" +
			" VALUES (?)",
			new String[] { "access_id" });
			ps.setString(1, access.getFunctionType());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this value must be returned
			int id = rs.getInt(1);
			access.setAccessId(id);;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
		return access;
	}
	
	public AccessBean update(AccessBean access) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE Access_Type SET funtion_type = ? WHERE access_id = ?");
			ps.setInt(1, access.getAccessId());
			ps.setString(2, access.getFunctionType());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
		return access;
	}
	
	public boolean remove(int id) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM Access_Type WHERE access_id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count == 1;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
	}

}
