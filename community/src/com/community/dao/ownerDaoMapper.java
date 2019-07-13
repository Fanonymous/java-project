package com.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.community.entity.admin;
import com.community.entity.owner;
import com.community.utils.MyBatisUtils;

public class ownerDaoMapper {



	public static  boolean  saveownerInfo(owner owner){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.insert("saveownerInfo", owner);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}	
	}
	
	
	
	public static  boolean  updateownerInfo(owner owner){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.update("updateownerInfo", owner);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}	
	}
	
	
	
	public  static owner findownerById(int id){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		owner owner=sqlSession.selectOne("findownerById",id);
		MyBatisUtils.closeSession(sqlSession);
		return owner;
	}
	
	
	
	
	public static  int getownerCount(){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.selectOne("getownerCount");
		MyBatisUtils.closeSession(sqlSession);
		return count;
	}
	/**
	 * 业主分页查询
	 * @param map
	 * @return
	 */
	public static  List<owner>findownerWithPage(Map<String,Object>map){
		List<owner>list=null;
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		try {
			list=sqlSession.selectList("findownerWithPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSession(sqlSession);
		}
		return list;
	}
	
	
	
	public static boolean delownerInfo(int ownerid) {
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		int count=sqlSession.delete("delownerInfo", ownerid);
		sqlSession.commit();
		MyBatisUtils.closeSession(sqlSession);
		if(count!=0){
			return true;
		}else{
			return false;
		}
	}
}
