package com.wuliuSystem.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wuliuSystem.entity.wuliuMessage;
import com.wuliuSystem.util.DBUtil;

public class wuliuMessageDao extends DBUtil {
	/***
	 * 运单处理
	 * @param me
	 */
	public void add(wuliuMessage me) {
		try {
			Connection conn = getConn();
			PreparedStatement ps = conn
					.prepareStatement("insert into wuliuMessage(orderID,adminID,siteID,starttime,goodstatus,remarks) values(?,?,?,getdate(),?,?)");
			ps.setString(1, me.getOrderID());
			ps.setInt(2, me.getAdminID());
			ps.setInt(3, me.getSideID());
			ps.setString(4, me.getGoodstatus());
			ps.setString(5, me.getRemarks());
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Map<String, Object>> getAllForOrder(String onum) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			Connection conn = getConn();
			Statement sta = conn.createStatement();
			ResultSet rs = sta
					.executeQuery("select * from vi_wuliuMessage where orderID='" + onum
							+ "' order by starttime");
			while (rs.next()) {
				Map<String, Object> l = new HashMap<String, Object>();
				l.put("ln", rs.getInt("mid"));
				l.put("on", rs.getString("orderID"));
				l.put("en", rs.getInt("adminID"));
				l.put("wn", rs.getInt("siteID"));				
				l.put("time", rs.getString("starttime"));
				l.put("opr", rs.getString("goodstatus"));
				l.put("msg", rs.getString("remarks"));
				l.put("ename", rs.getString("Name"));
				l.put("wname", rs.getString("siteName"));
				list.add(l);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
