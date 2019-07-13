package com.gzmu.interManSys.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private String jdbcName="com.mysql.jdbc.Driver";						//���ݿ�������
	private String dbUrl="jdbc:mysql://localhost:3306/db_internetsys";		//���ݿ��ַ
	private String dbUserName="root";										//���ݿ��û���
	private String dbPassword="123456";										//���ݿ��¼����
	
	//��������
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		java.sql.Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	//�ر����ݿ�
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	//�������ݿ�����
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try{
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ���");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
