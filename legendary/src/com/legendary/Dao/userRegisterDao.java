package com.legendary.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.legendary.utils.DBUtil;

public class userRegisterDao extends DBUtil {
	public int zhuce(userRegister user) {
		String sql = "insert into  userregister (accountNumber,nickname,password,sex,birthday,location,tel) values(?,?,?,?,?,?,?)";

		Object[] params = new Object[] { user.getAccountNumber(), user.getNickname(), user.getPassword(), user.getSex(),
				user.getBirthday(), user.getLocation(), user.getTel() };
		return super.executeUpdate(sql, params);
	}

	public boolean login(String accountNumber, String password) {
		String sql = "select * from userRegister where accountNumber=? and password=?";
		Object[] params = new Object[] { accountNumber, password };
		List<userRegister> us = super.executeQuery(sql, params, userRegister.class);
		if (us.size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	// 查询所有用户
	public Vector<userRegister> getAll() {
		Vector<userRegister> v=new Vector<userRegister>();

		
		try {
			Connection conn = getConn();
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery(
					"SELECT userregister.id,userregister.accountNumber,userregister.nickname,userregister.`password`,userregister.sex,userregister.birthday,userregister.location,userregister.tel FROM userregister");
			while(rs.next()){
				userRegister user=new userRegister();
				user.setId(rs.getInt("id"));
				user.setAccountNumber(rs.getString("accountNumber"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getString("birthday"));
				user.setLocation(rs.getString("location"));
				user.setTel(rs.getString("tel"));
				v.add(user);
			}
			rs.close();
			sta.close();
			conn.close();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return v;

	}

}
