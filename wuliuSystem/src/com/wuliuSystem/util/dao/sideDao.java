package com.wuliuSystem.util.dao;

import com.wuliuSystem.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wuliuSystem.entity.site;
public class sideDao extends DBUtil{
	/****
	 * 查询所有站点
	 * @return
	 */
	public List<site> getAll() {
		List<site> list = new ArrayList<site>();

		try {
			Connection conn = getConn();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from site");
			while (rs.next()) {
				site w = new site();
				w.setSiteID(rs.getInt("siteID"));
				w.setSiteName(rs.getString("siteName"));
				w.setAddress(rs.getString("address"));
				w.setPhone(rs.getString("phone"));
				list.add(w);
			}
			rs.close();
			sta.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
/***
 * 添加站点
 * @param w
 */
	public void add(site w) {
		try {
			Connection conn = getConn();
			PreparedStatement ps = conn
					.prepareStatement("insert into site(adminID,siteName,address,phone) values(?,?,?,?)");
			ps.setInt(1, w.getAdminID());
			ps.setString(2, w.getSiteName());
			ps.setString(3, w.getAddress());
			ps.setString(4, w.getPhone());
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/***
	 * 删除站点
	 * @param num
	 */
	public void delete(int num) {
		try {
			Connection conn = getConn();
			Statement sta = conn.createStatement();
			sta.executeUpdate("delete from site where siteID=" + num);
			sta.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public site get(int id) {
		site w = null;

		try {
			Connection conn = getConn();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery("select * from site where siteID="
					+ id);
			if (rs.next()) {
				w = new site();
				w.setSiteID(rs.getInt("siteID"));
				w.setAdminID(rs.getInt("adminID"));
				w.setSiteName(rs.getString("siteName"));
				w.setAddress(rs.getString("address"));
				w.setPhone(rs.getString("phone"));
			}
			rs.close();
			sta.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return w;
	}
	
	public void update(site w) {
		try {
			Connection conn = getConn();
			PreparedStatement ps = conn
					.prepareStatement("update site set adminID=?,siteName=?,address=?,phone=? where siteID=?");
			
			ps.setInt(1, w.getAdminID());
			ps.setString(2, w.getSiteName());
			ps.setString(3, w.getAddress());
			ps.setString(4, w.getPhone());
			ps.setInt(5, w.getSiteID());
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
