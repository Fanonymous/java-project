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
	 * ���SqlSession���󣬸ö������ṩ�˲������ݿ����ɾ�Ĳ鷽��
	 */
	
	public static SqlSession getSqlSession(){
		return factory.openSession();
	}
	/**
	 * �ر������ͷ���Դ
	 */
    public static void closeSession(SqlSession session){
    	if(session!=null){
    		session.close();
    	}
    }

}
