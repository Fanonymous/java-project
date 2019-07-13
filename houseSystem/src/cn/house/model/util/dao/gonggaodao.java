package cn.house.model.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.house.model.util.DBUtil;

import cn.house.vo.gonggao;


public class gonggaodao extends DBUtil {
	/****
	 * 查询公告
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<gonggao> querycardbyuc(int start, int limit) {
		String sql = "select * from gonggao limit " + start + "," + limit;
		// 创建Object数组
		Object[] params = new Object[] {};
		// 调用父类中的查询方法
		List<gonggao> emps = super.executeQuery(sql, params, gonggao.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}

	/****
	 * 添加公告
	 * 
	 * @param us
	 * @return
	 */
	public int increas(gonggao us) {
		String sql = "insert into  gonggao (gG) values(?)";
		// 提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[] { us.getGg() };
		// 调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}

	/****
	 * 删除公告
	 * 
	 * @param ggId
	 * @return
	 */
	public int delet(int ggId) {
		String sql = "delete from gonggao where ggId=?";
		Object[] params = new Object[] { ggId };
		return super.executeUpdate(sql, params);

	}

	/****
	 * 通过公告号查询公告
	 * 
	 * @param ggId
	 * @return
	 */
	public List<gonggao> querycardbyid(int ggId) {
		String sql = "select * from gonggao where ggId=?";
		// 创建Object数组
		Object[] params = new Object[] { ggId };
		// 调用父类中的查询方法
		List<gonggao> emps = super.executeQuery(sql, params, gonggao.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}

	/****
	 * 获得公告总计录数
	 * 
	 * @return
	 */
	public int getEmployeeNumber() {
		int count = 0;
		String sql = "select ggId from  gonggao";
		ResultSet rs = null;
		try {
			Statement st = super.getConn().createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				rs.getInt(1);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/****
	 * 根据公告编号修改公告
	 * 
	 * @param us
	 * @return
	 */
	public int xiugai(gonggao car){
		String sql = "update gonggao set gg=? where ggId=?";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{car.getGg(),car.getGgId()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);

	}
}
