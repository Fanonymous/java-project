package cn.itcase.util;

import java.lang.reflect.Field;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;
import org.apache.commons.beanutils.ConvertUtils;

public abstract class DBUtil {
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	//链接数据库的驱动字符串
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//链接数据库的链接字符串
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=ATM";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";
	/***
	 * 链接数据库方法
	 * @return
	 */
	protected Connection getConn(){
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/***
	 * 释放资源
	 */
	protected void closeAll(){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/***
	 * 执行增、删、改操作
	 * @param sql
	 * @param params
	 * @return
	 */
	protected int executeUpdate(String sql,Object[] params){
		int result = 0;
		try {
			ps = this.getConn().prepareStatement(sql);
			if(params != null && params.length != 0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return result;
	}
	/***
	 * 通用查询方法
	 * @param sql
	 * @param params
	 * @param cla
	 * @return
	 */
	
	protected List executeQuery(String sql,Object[] params,Class cla){
		List list = new ArrayList();
		try {
			ps = this.getConn().prepareStatement(sql);
			if(params != null && params.length != 0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			//结果集处理，使用反射来完成通用的封装
			ResultSetMetaData rsmt = rs.getMetaData();//获得一个表示结果集对象结构的对象
			while(rs.next()){
				Object obj = cla.newInstance();//创建类的一个实例，根据类的反射
				//获得各列的数据
				for(int i=0;i<rsmt.getColumnCount();i++){
				//获得列名
					String columnName = rsmt.getColumnName(i+1);
					//根据列名获得属性
					Field field = cla.getDeclaredField(columnName);
					//拼接set方法名
					
					String methodName = "set" + columnName.substring(0,1).toUpperCase() + columnName.substring(1);
					//根据方法名获得set方法
					Method method = cla.getDeclaredMethod(methodName, new Class[]{field.getType()});
					//调用对象的set方法为属性赋值
					method.invoke(obj,new Object[]{ConvertUtils.convert(rs.getString(i+1), field.getType()) });
					
				}
				list.add(obj);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		return list;
	}
}
