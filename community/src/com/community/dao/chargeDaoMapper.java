package com.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.community.entity.charge;
import com.community.utils.MyBatisUtils;

public class chargeDaoMapper {
	
	public static charge   findchargeById(int id){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		charge charge=sqlSession.selectOne("findchargeById",id);
		MyBatisUtils.closeSession(sqlSession);
		return charge;
	}
	
	
	public static charge  findchargeByhouseid(String houseid){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		charge charge=sqlSession.selectOne("findchargeByhouseid",houseid);
		MyBatisUtils.closeSession(sqlSession);
		return charge;
	}
	
	

	public static  boolean  savechargeInfo(charge charge){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.insert("savechargeInfo", charge);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}
	}
	
	public static  boolean  updatechargeInfo(charge charge){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.update("updatechargeInfo", charge);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static  boolean  updatechargeByhouseid(charge charge){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.update("updatechargeByhouseid", charge);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	
	

	public static  int getchargeCount(){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.selectOne("getchargeCount");
		MyBatisUtils.closeSession(sqlSession);
		return count;
	}
	
	public static  List<charge>findchargeWithPage(Map<String,Object>map){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		List<charge>list=sqlSession.selectList("findchargeWithPage", map);
		MyBatisUtils.closeSession(sqlSession);
		return list;
	}
}
