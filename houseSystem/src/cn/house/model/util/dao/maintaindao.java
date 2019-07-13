package cn.house.model.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.house.model.util.DBUtil;

import cn.house.vo.maintain;

public class maintaindao extends DBUtil{
	/****
	 * 用户报修事件
	 * @param mt
	 * @return
	 */
	public int baoxiu(maintain mt){
		String sql = "insert into maintain(maintain_thing,maintain_homesnumber,maintain_fh,maintain_smemo)  values(?,?,?,?)";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{mt.getMaintain_thing(),mt.getMaintain_homesnumber(),mt.getMaintain_fh(),mt.getMaintain_smemo()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}
	/****
	 * 查询
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<maintain> querycardbyuc(int start, int limit) {
		String sql = "select * from maintain limit " + start + "," + limit;
		// 创建Object数组
		Object[] params = new Object[] {};
		// 调用父类中的查询方法
		List<maintain> emps = super.executeQuery(sql, params, maintain.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}
	/****
	 * 通过维修工号添加信息
	 * @param us
	 * @return
	 */
	public int increas(maintain us) {
		String sql = "insert into  maintain (maintainID) values(?)";
		// 提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[] { us.getMaintainID() };
		// 调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}
	/****
	 * 通过维修编号删除维修信息
	 * @param maintainID
	 * @return
	 */
	public int delet(int maintainID) {
		String sql = "delete from maintain where maintainID=?";
		Object[] params = new Object[] { maintainID };
		return super.executeUpdate(sql, params);

	}
	/****
	 * 通过编号查询维修报告
	 * @param maintainID
	 * @return
	 */
	public List<maintain> querycardbyid(int maintainID) {
		String sql = "select * from maintain where maintainID=?";
		// 创建Object数组
		Object[] params = new Object[] { maintainID };
		// 调用父类中的查询方法
		List<maintain> emps = super.executeQuery(sql, params, maintain.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}
	/****
	 * 获得总计录数
	 * @return
	 */
	public int getEmployeeNumber() {
		int count = 0;
		String sql = "select maintainID from  maintain";
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
	 * 通过维修编号，修改维修状态
	 * @param us
	 * @return
	 */
	public int xiugai(maintain car){
		String sql = "update maintain set shifouweixiu=? where maintainID=?";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{car.getShifouweixiu(),car.getMaintainID()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);

	}


}
