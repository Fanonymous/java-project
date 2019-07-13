package cn.itcase.dao;

import java.util.List;

import cn.itcase.shuju.cards;
import cn.itcase.shuju.users;
import cn.itcase.util.DBUtil;
/***
 * 用户对象数据库操作
 * @author Administrator
 *
 */
public class userdao extends DBUtil{

	/***
	 * 用户注册
	 */
	public int zhuce(users us){
		String sql = "insert into  users values(?,?,?,?,?)";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{us.getUcnoid(),us.getName(),us.getSex(),us.getCardid(),us.getpassword()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
		
	}
	public int zhu(cards us){
		String sqll = "insert into  cards values(?,?)";
		Object[] paramss = new Object[]{us.getUcnoid(),us.getYue()};
		return super.executeUpdate(sqll, paramss);
	}
	/***
	 * 用户登录
	 * @param empNoucnoid
	 * @param password
	 * @return
	 */
	public boolean login(String ucnoid,String password){
		//创建SQL语句(带有？号占位符的表示当前SQL语句是不完整的)
		String sql = "select * from users where ucnoid=? and password=?";
		//Object数组中的元素表示SQL语句中问号占位符的值
		Object[] params = new Object[]{ucnoid,password};
		//调用父类中的查询方法，进行登录操作
		List<users> us = super.executeQuery(sql, params, users.class);
		if(us.size() != 0){
			return true;
		}else{
			return false;			
		}
	}
	/****
	 * 修改密码
	 * @param us
	 * @return
	 */
	public int gaimi(users us){
		String sql = "update users set password=? where ucnoid=?";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{us.getpassword(),us.getUcnoid()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}
	

}
