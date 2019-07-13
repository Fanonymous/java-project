package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DateUtil;
import com.gzmu.interManSys.util.StringUtil;

public class PersonInfoModifyDao {
	//显示个人信息，
	public ResultSet personInfoList(Connection con,PageBean pageBean,User user) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_user where userName like '%"+user.getMyName()+"%'");
		//分页
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	//统计个人信息记录数，当然只有一条
	public int personinfoCount(Connection con, User user) throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_user");
		//判断账户是否为空
		if(StringUtil.isNotEmpty(user.getUserName())){
			sb.append(" where userName like '%"+user.getMyName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}
		else{
			return 0;
		}
	}
	//个人信息修改事件
	public int personInfoModify(Connection con,User user) throws Exception{
		String sql="update t_user set name=?, sex=?, birthday=?, grade=?, major=?, phone=?, address=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getSex());
		ps.setString(3, DateUtil.formaDate(user.getBirthday(), "yyyy-MM-dd") );
		ps.setString(4, user.getGrade());
		ps.setString(5, user.getMajor());
		ps.setString(6, user.getPhone());
		ps.setString(7, user.getAddress());
		ps.setInt(8, user.getUserId());
		return ps.executeUpdate();
	}
	//个人密码修改事件
	public int personPWDModify(Connection con,User user) throws Exception{
		String sql="update t_user set password=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getPassword());
		ps.setInt(2, user.getUserId());
		return ps.executeUpdate();
	}
}
