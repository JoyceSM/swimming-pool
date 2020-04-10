package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.PaymentBean;
import com.ait.swimmingpool.dbconnection.ConnectionHelper;

public class PaymentDAO {
	public List<PaymentBean> findAll() {
		List<PaymentBean> list = new ArrayList<PaymentBean>();
		Connection c = null;
		String sql = "SELECT * FROM Payment";
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
	
	protected PaymentBean processRow(ResultSet rs) throws SQLException {
		PaymentBean payment = new PaymentBean();
		payment.setPaymentId(rs.getInt("payment_id"));
		payment.setUserId(rs.getInt("user_id"));
		payment.setAmount(rs.getDouble("amount"));
		payment.setPaymentDate(rs.getString("payment_date"));
		return payment;
	}
	
	public PaymentBean create(PaymentBean payment) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement("INSERT INTO payment" +
			" (user_id, amount, payment_date)" +
			" VALUES (?, ?, ?)",
			new String[] { "payment_id" });
			ps.setInt(1, payment.getUserId());
			ps.setDouble(2, payment.getAmount());
			ps.setString(3, payment.getPaymentDate());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			// Update the id in the returned object. This is important as this value must be returned
			int id = rs.getInt(1);
			payment.setPaymentId(id);;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
		return payment;
	}
	
	public PaymentBean update(PaymentBean payment) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE Payment SET user_id = ?, amount = ?, payment_date = ? " +
			"WHERE payment_id = ?");
			ps.setInt(1, payment.getUserId());
			ps.setDouble(2, payment.getAmount());
			ps.setString(3, payment.getPaymentDate());
			ps.setInt(4, payment.getPaymentId());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnectionHelper.close(c);
		}
		return payment;
	}
	
	public boolean remove(int id) {
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("DELETE FROM Payment WHERE payment_id=?");
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
