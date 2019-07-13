package cn.itcase.dao;



import java.util.List;

import cn.itcase.shuju.cards;
import cn.itcase.shuju.users;
import cn.itcase.util.DBUtil;

public class cardsdao extends DBUtil{
	/****
	 * 查询余额
	 */
	public cards querycardbyuc(String ucnoid){
		String sql = "select * from cards where ucnoid=?";
		//创建Object数组
		Object[] params = new Object[]{ucnoid};
		//调用父类中的查询方法
		List<cards> emps = super.executeQuery(sql, params, cards.class);
		if(emps.size()!=0){
			return emps.get(0);
		}else{
			return null;
		}
	}
	/***
	 * 存款
	 * @param car
	 * @return
	 */
	public int cunkuan(cards car){
		String sql = "update cards set yue=? where ucnoid=?";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{car.getYue(),car.getUcnoid()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}
	/****
	 * 取款
	 * @param car
	 * @return
	 */
	public int qukuan(cards car1){
		String sql = "update cards set yue=? where ucnoid=?";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{car1.getYue(),car1.getUcnoid()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}

}

