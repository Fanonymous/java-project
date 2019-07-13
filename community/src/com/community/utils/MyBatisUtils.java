package com.community.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;


public class MyBatisUtils {
	private static SqlSessionFactory  factory=null;
	static{
		try {
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获得SqlSession对象，该对象中提供了操作数据库的增删改查方法
	 */
	
	public static SqlSession getSqlSession(){
		return factory.openSession();
	}
	/**
	 * 关闭连接释放资源
	 */
    public static void closeSession(SqlSession session){
    	if(session!=null){
    		session.close();
    	}
    }

}
