package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DateUtil;
import com.gzmu.interManSys.util.StringUtil;

public class PersonInfoModifyDao {
	//��ʾ������Ϣ��
	public ResultSet personInfoList(Connection con,PageBean pageBean,User user) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_user where userName like '%"+user.getMyName()+"%'");
		//��ҳ
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	//ͳ�Ƹ�����Ϣ��¼������Ȼֻ��һ��
	public int personinfoCount(Connection con, User user) throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_user");
		//�ж��˻��Ƿ�Ϊ��
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
	//������Ϣ�޸��¼�
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
	//���������޸��¼�
	public int personPWDModify(Connection con,User user) throws Exception{
		String sql="update t_user set password=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getPassword());
		ps.setInt(2, user.getUserId());
		return ps.executeUpdate();
	}
}
