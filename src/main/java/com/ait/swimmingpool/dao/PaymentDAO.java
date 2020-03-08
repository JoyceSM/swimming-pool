package com.ait.swimmingpool.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.swimmingpool.bean.PaymentBean;
import com.ait.swimmingpool.bean.UserBean;
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
		payment.setUserId(rs.getString("user_id"));
		payment.setAmount(rs.getDouble("amount"));
		payment.setPaymentDate(rs.getString("payment_date"));
		return payment;
	}
}
