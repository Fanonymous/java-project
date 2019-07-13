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
	//�������ݿ�������ַ���
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//�������ݿ�������ַ���
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=ATM";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";
	/***
	 * �������ݿⷽ��
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
	 * �ͷ���Դ
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
	 * ִ������ɾ���Ĳ���
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
	 * ͨ�ò�ѯ����
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
			//���������ʹ�÷��������ͨ�õķ�װ
			ResultSetMetaData rsmt = rs.getMetaData();//���һ����ʾ���������ṹ�Ķ���
			while(rs.next()){
				Object obj = cla.newInstance();//�������һ��ʵ����������ķ���
				//��ø��е�����
				for(int i=0;i<rsmt.getColumnCount();i++){
				//�������
					String columnName = rsmt.getColumnName(i+1);
					//���������������
					Field field = cla.getDeclaredField(columnName);
					//ƴ��set������
					
					String methodName = "set" + columnName.substring(0,1).toUpperCase() + columnName.substring(1);
					//���ݷ��������set����
					Method method = cla.getDeclaredMethod(methodName, new Class[]{field.getType()});
					//���ö����set����Ϊ���Ը�ֵ
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
