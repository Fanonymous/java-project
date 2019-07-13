package com.community.dao;

import org.apache.ibatis.session.SqlSession;

import com.community.entity.payCost;
import com.community.utils.MyBatisUtils;

public class payCostDaoMapper {
	public static  boolean  savepayCostInfo(payCost payCost){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.insert("savepayCostInfo", payCost);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}	
	}
	

}
