package com.community.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.community.entity.admin;
import com.community.utils.MyBatisUtils;

public class adminDaoMapper {
	
	/***
	 * 登录
	 * @param map
	 * @return
	 */
	public static boolean login(Map<String,Object>map){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		List list=sqlSession.selectList("login",map);
		MyBatisUtils.closeSession(sqlSession);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
		
	}
	/***
	 * 插入
	 * @param map
	 * @return
	 */
	public static boolean saveadminInfo(admin admin){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		 int flag=0;
		try {
			flag=sqlSession.insert("saveadminInfo", admin);
			sqlSession.commit();//提交事物
			if(flag!=0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}finally{
			MyBatisUtils.closeSession(sqlSession);
		}
	} 
	
	/***
	 * 更新
	 * @param map
	 * @return
	 */
	public static boolean updateadminInfo(admin admin){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		 int flag=0;
		try {
			flag=sqlSession.update("updateadminInfo", admin);
			sqlSession.commit();
			if(flag!=0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}finally{
			MyBatisUtils.closeSession(sqlSession);
		}
	} 
	
	
	
	public static boolean updateadminInfoByadmin_number(String admin_number){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		 int flag=0;
		try {
			flag=sqlSession.update("updateadminInfoByadmin_number", admin_number);
			sqlSession.commit();
			if(flag!=0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}finally{
			MyBatisUtils.closeSession(sqlSession);
		}
	} 
	
	
	/***
	 * 删除
	 * @param userId
	 * @return
	 */
	public static boolean delUserInfo(int adminId){
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		 int flag=0;
		try {
			flag=sqlSession.delete("delUserInfo", adminId);
			sqlSession.commit();
			if(flag!=0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}finally{
			MyBatisUtils.closeSession(sqlSession);
		}
	} 
	
	
	/**
	 * 
	 * 查询方法
	 */	
	public static  List<admin>findadminWithPage(Map<String,Object>map){
		List<admin>list=null;
		SqlSession sqlSession=MyBatisUtils.getSqlSession();
		try {
			list=sqlSession.selectList("findadminAllInfo", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSession(sqlSession);
		}
		return list;
	}

}
