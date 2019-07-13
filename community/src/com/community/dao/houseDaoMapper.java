package com.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.community.entity.house;
import com.community.utils.MyBatisUtils;

public class houseDaoMapper {

	public static  boolean  savehouseInfo(house house){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.insert("savehouseInfo", house);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}	
	}
	
	
	
	public static  boolean  updatehouseInfo(house house){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.update("updatehouseInfo", house);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}	
	}
	
	
	
	public  static house findownerById(int id){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		house owner=sqlSession.selectOne("findhouseById",id);
		MyBatisUtils.closeSession(sqlSession);
		return owner;
	}
	
	
	
	
	public static  int gethouseCount(){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.selectOne("gethouseCount");
		MyBatisUtils.closeSession(sqlSession);
		return count;
	}
	/**
	 * 业主分页查询
	 * @param map
	 * @return
	 */
	public static  List<house>findhouseWithPage(Map<String,Object>map){
		List<house>list=null;
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		try {
			list=sqlSession.selectList("findhouseWithPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSession(sqlSession);
		}
		return list;
	}
	
	
	
	public static boolean delhouseInfo(int houseid) {
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.delete("delhouseInfo", houseid);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}
	}

}
