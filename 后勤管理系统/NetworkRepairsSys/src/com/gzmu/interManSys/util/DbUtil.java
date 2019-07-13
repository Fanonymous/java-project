package com.gzmu.interManSys.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private String jdbcName="com.mysql.jdbc.Driver";						//数据库驱动名
	private String dbUrl="jdbc:mysql://localhost:3306/db_internetsys";		//数据库地址
	private String dbUserName="root";										//数据库用户名
	private String dbPassword="123456";										//数据库登录密码
	
	//连接数据
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		java.sql.Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	//关闭数据库
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	//测试数据库连接
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try{
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
