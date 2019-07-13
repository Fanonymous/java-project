package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.StringUtil;

public class TaskReceiveDao {
	//��ʾ����������Ϣ���Լ���ѯ����
	public ResultSet taskList(Connection con,PageBean pageBean, Task task) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_repair where state = '��ά��'");
		//����û�������Ϊ�գ�����Ϊ�գ����ѯ����������ļ�¼��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getPublishTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//�û���ַ��Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getPublishTime())){
			sb.append(" and userAddress like '%"+task.getUserAddress()+"%'");
		}
		//����û�����ʱ�䲻Ϊ�գ����ѯ����ü�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and publishTime like '%"+task.getPublishTime()+"%'");
		}
		//��������͵�ַ����Ϊ�յ�ʱ���Ա�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getPublishTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like'%"+task.getUserAddress()+"%'");
		}
		//���������b����ʱ�䶼��Ϊ�գ���ַΪ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and publishTime like '%"+task.getPublishTime()+"%'");
		}
		//����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and userAddress like '%"+task.getRepairer()+"%' and publishTime like '%"+task.getPublishTime()+"%'");
		}
		//����������˻����Ա𶼲�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like '%"+task.getRepairer()+"%' and publishTime like '%"+task.getPublishTime()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	//ͳ�������¼��
	public int taskReceiveCount(Connection con, Task task) throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_repair where state = '��ά��'");
		//����û�������Ϊ�գ�����Ϊ�գ����ѯ����������ļ�¼��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getPublishTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//�û���ַ��Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getPublishTime())){
			sb.append(" and userAddress like '%"+task.getUserAddress()+"%'");
		}
		//����û�����ʱ�䲻Ϊ�գ����ѯ����ü�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and publishTime like '%"+task.getPublishTime()+"%'");
		}
		//��������͵�ַ����Ϊ�յ�ʱ���Ա�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getPublishTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like'%"+task.getUserAddress()+"%'");
		}
		//���������b����ʱ�䶼��Ϊ�գ���ַΪ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and publishTime like '%"+task.getPublishTime()+"%'");
		}
		//����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and userAddress like '%"+task.getRepairer()+"%' and publishTime like '%"+task.getPublishTime()+"%'");
		}
		//����������˻����Ա𶼲�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getPublishTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like '%"+task.getRepairer()+"%' and publishTime like '%"+task.getPublishTime()+"%'");
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

	//ά�ޱ��޵��¼����൱���޸ı���ʱ�䣬�����ߺͱ���״̬,�����������ְԱͬʱ�������� ���Թؼ���synchronized
	public synchronized int taskReceive(Connection con,Task task) throws Exception{
		String sql="update t_repair set repairer=?,repairTime=?,state=? where taskId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, task.getRepairer());
		ps.setString(2, task.getRepairTime());
		ps.setString(3, task.getState());
		ps.setInt(4, task.getTaskId());
		return ps.executeUpdate();
	}
}
