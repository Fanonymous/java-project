package com.legendary.Dao;

import com.legendary.utils.DBUtil;

public class logDao extends DBUtil{
	
	//±£¥Ê»’÷æ
	public int log(serverlog l){
		String sql="insert into serverlog (log) values(?)";
		Object[] params = new Object[]{l.getLog()};
		return super.executeUpdate(sql, params);
	}

}
