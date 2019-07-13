package cn.house.model.util.dao;

import java.util.List;

import cn.house.model.util.DBUtil;
import cn.house.vo.admin;



	public class adminDao extends DBUtil{
		/*****
		 * 管理员登陆
		 */
		public boolean login(int adminId,String admin_password){
			//创建SQL语句(带有？号占位符的表示当前SQL语句是不完整的)
			String sql = "select * from admin where adminId=? and admin_password=?";
			//Object数组中的元素表示SQL语句中问号占位符的值
			Object[] params = new Object[]{adminId,admin_password};
			//调用父类中的查询方法，进行登录操作
			List<admin> us = super.executeQuery(sql, params, admin.class);
			if(us.size() != 0){
				return true;
			}else{
				return false;			
			}
		}
		/****
		 * 管理员修改密码
		 * @param cus
		 * @return
		 */
		public int gaimi(admin cus){
			String sql = "update admin set admin_password=? where adminId=?";
			//提供SQL语句中？号占位符的值(使用Object数组提供)
			Object[] params = new Object[]{cus.getAdmin_password(),cus.getAdminId()};
			//调用父类中的executeUpdate方法执行sql语句
			return super.executeUpdate(sql, params);
		}

}
