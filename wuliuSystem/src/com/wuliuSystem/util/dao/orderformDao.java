package com.wuliuSystem.util.dao;

import com.wuliuSystem.util.DBUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.wuliuSystem.entity.orderform;
import com.wuliuSystem.entity.wuliuadmin;

public class orderformDao extends DBUtil {
	/***
	 * 下单
	 * 
	 * @param us
	 * @return
	 */
	public int orderform(orderform us) {
		String sql = "insert into  orderform (transportType,resisteredTime,sendplace,receiveplace,goodsType,goodsNumber,outNmae,outPhone,inName,inPhone,cost,remarks,adminID) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// 提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[] { us.getTransportType(), us.getResisteredTime(), us.getSendplace(),
				us.getReceiveplace(), us.getGoodsType(), us.getGoodsNumber(), us.getOutNmae(), us.getOutPhone(),
				us.getInName(), us.getInPhone(), us.getCost(), us.getRemarks()};
		// 调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}

	/****
	 * 根据单号查询订单
	 * 
	 * @param ID
	 * @return
	 */
	public List<orderform> querycardbyid(String orderID) {
		String sql = "select * from orderform where orderID=?";
		// 创建Object数组
		Object[] params = new Object[] { orderID };
		// 调用父类中的查询方法
		List<orderform> emps = super.executeQuery(sql, params, orderform.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}

	//
	/***
	 * 取消订单
	 * 
	 * @param orderID
	 * @return
	 */
	public int delet(int orderID) {
		String sql = "delete from orderform where orderID=?";
		Object[] params = new Object[] { orderID };
		return super.executeUpdate(sql, params);

	}


		public void addOrder(orderform o, wuliuadmin e) {
			
			try {
				Connection conn=getConn();
				CallableStatement cs=conn.prepareCall("{call add_order(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cs.registerOutParameter(1, Types.CHAR);
				cs.setString(2, o.getTransportType());
				cs.setString(3, o.getResisteredTime());
				cs.setString(4, o.getSendplace());
				cs.setString(5, o.getReceiveplace());				
				cs.setString(6, o.getGoodsType());
				cs.setString(7, o.getGoodsNumber());
				cs.setString(8, o.getOutNmae());
				cs.setString(9, o.getOutPhone());
				cs.setString(10, o.getInName());
				cs.setString(11, o.getInPhone());
				cs.setInt(12, o.getCost());
				cs.setString(13, o.getRemarks());
				cs.setInt(14, e.getAdminID());
				cs.setInt(15, e.getSiteID());
				cs.executeUpdate();
								
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
    
	

