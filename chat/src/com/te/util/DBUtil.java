package com.te.util;

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
/***
 * 锟斤拷菘锟侥革拷锟斤拷锟斤拷
 * 锟斤拷锟斤拷锟斤拷峁╋拷锟捷匡拷锟斤拷锟斤拷印锟斤拷头锟斤拷锟皆达拷锟斤拷锟缴撅拷暮筒锟窖拷锟斤拷锟�
 * @author Administrator
 *
 */
public abstract class DBUtil {
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	//锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟街凤拷
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟街凤拷
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=legendary";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";
	/***
	 * 锟斤拷锟斤拷锟斤拷菘夥斤拷锟�
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
	 * 锟酵凤拷锟斤拷源
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
	 * 执锟斤拷锟斤拷锟斤拷删锟斤拷锟侥诧拷锟斤拷
	 * @param sql    SQL锟斤拷锟�
	 * @param params   锟斤拷示SQL锟斤拷锟斤拷校锟斤拷锟秸嘉伙拷锟斤拷值
	 * @return   int 锟斤拷锟斤拷0锟斤拷示锟缴癸拷    锟斤拷锟斤拷0锟斤拷示失锟斤拷
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
	 * 通锟矫诧拷询锟斤拷锟斤拷
	 * @param sql     SQL锟斤拷锟�
	 * @param params    锟斤拷示SQL锟斤拷锟斤拷校锟斤拷锟秸嘉伙拷锟斤拷值
	 * @param cla     锟斤拷示锟斤拷前锟斤拷询锟斤拷锟窖拷谋锟斤拷锟絁ava锟斤拷锟斤拷锟接︼拷锟斤拷锟斤拷锟斤拷锟斤拷.class
	 * @return  list  锟斤拷示锟斤拷询锟斤拷慕锟斤拷
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
			//锟斤拷锟斤拷?使锟矫凤拷锟斤拷锟斤拷锟斤拷锟酵拷玫姆锟阶�
			ResultSetMetaData rsmt = rs.getMetaData();//锟斤拷锟揭伙拷锟斤拷锟绞撅拷锟斤拷锟斤拷锟结构锟侥讹拷锟斤拷
			while(rs.next()){
				Object obj = cla.newInstance();//锟斤拷锟斤拷锟斤拷锟揭伙拷锟绞碉拷锟斤拷锟斤拷锟侥凤拷锟斤拷
				//锟斤拷酶锟斤拷械锟斤拷锟斤拷
				for(int i=0;i<rsmt.getColumnCount();i++){
				//锟斤拷锟斤拷锟斤拷锟�
					String columnName = rsmt.getColumnName(i+1);
					//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
					
					Field field = cla.getDeclaredField(columnName);
					//拼锟斤拷set锟斤拷锟斤拷锟斤拷
					
					String methodName = "set" + columnName.substring(0,1).toUpperCase() + columnName.substring(1);
					//锟斤拷莘锟斤拷锟斤拷锟斤拷锟絪et锟斤拷锟斤拷
					Method method = cla.getDeclaredMethod(methodName, new Class[]{field.getType()});
					//锟斤拷锟矫讹拷锟斤拷锟絪et锟斤拷锟斤拷为锟斤拷锟皆革拷值
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
