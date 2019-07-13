package com.wuliuSystem.util.dao;

import com.wuliuSystem.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.wuliuSystem.entity.wuliuadmin;

public class wuliuadminDao extends DBUtil{
	

		public wuliuadmin loginadmin(String name, String pass) {
			wuliuadmin e = null;

			try {
				Connection conn = getConn();
				Statement sta = conn.createStatement();
				ResultSet rs = sta
						.executeQuery("select * from wuliuadmin where Name='" + name
								+ "' and Password='" + pass + "'");
				if (rs.next()) {
					e = new wuliuadmin();
					e.setAdminID(rs.getInt("adminID"));
					e.setPassword(rs.getString("Password"));
					e.setName(rs.getString("Name"));
					e.setPhone(rs.getString("Phone"));
					e.setSiteID(rs.getInt("siteID"));
				}
				rs.close();
				sta.close();
				conn.close();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			return e;
		}
	}
