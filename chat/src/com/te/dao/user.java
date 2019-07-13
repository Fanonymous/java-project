package com.te.dao;

import java.util.List;

import com.te.entil.u;
import com.te.util.DBUtil;

public class user extends DBUtil{
	public u login(String sno,String password){
		String sql = "select * from u where custName=? and custPassword=?";
		Object[] params = new Object[]{sno,password};
		List<u> emps =  super.executeQuery(sql,params,u.class);
		if(emps.size() != 0){
			return emps.get(0);
		}else{
			return null;			
		}
	}
	public int addu(u stu){
		String sql = "insert into  u values(?,?,?,?,?,?)";
		Object[] params = new Object[]{stu.getCustName(),stu.getCustPassword(),stu.getAge(),stu.getSex(),stu.getEmail(),stu.getHead()+".jpg"};
		return super.executeUpdate(sql, params);
	}

}
