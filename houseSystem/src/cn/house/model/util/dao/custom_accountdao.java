package cn.house.model.util.dao;

import java.util.List;

import cn.house.model.util.DBUtil;
import cn.house.vo.custom_account;

public class custom_accountdao extends DBUtil{
	/****
	 * 业主登录方法
	 * @param ccustom_accountID
	 * @param custom_password
	 * @return
	 */
	public boolean login(int ccustom_accountID,String custom_password){
		//创建SQL语句(带有？号占位符的表示当前SQL语句是不完整的)
		String sql = "select * from custom_account where ccustom_accountID=? and custom_password=?";
		//Object数组中的元素表示SQL语句中问号占位符的值
		Object[] params = new Object[]{ccustom_accountID,custom_password};
		//调用父类中的查询方法，进行登录操作
		List<custom_account> us = super.executeQuery(sql, params, custom_account.class);
		if(us.size() != 0){
			return true;
		}else{
			return false;			
		}
	}
	/***
	 * 业主修改密码
	 * @param cus
	 * @return
	 */
	public int gaimi(custom_account cus){
		String sql = "update custom_account set custom_password=? where ccustom_accountID=?";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{cus.getCustom_password(),cus.getCcustom_accountID()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}

}
