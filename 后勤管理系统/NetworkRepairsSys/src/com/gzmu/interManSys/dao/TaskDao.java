package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.StringUtil;

public class TaskDao {
	//��ʾ����������Ϣ���Լ���ѯ����
	public ResultSet taskList(Connection con,PageBean pageBean, Task task) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_repair where state in('��ά��','ά����','��ά��')");
		//����û�������Ϊ�գ�����Ϊ�գ����ѯ����������ļ�¼��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//���ά���߲�Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%'");
		}
		//���״̬��Ϊ�գ����ѯ����ü�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and state like '%"+task.getState()+"%'");
		}
		//����������˻�����Ϊ�յ�ʱ���Ա�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and repairer like'%"+task.getRepairer()+"%'");
		}
		//���������״̬����Ϊ�գ�ά����Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and state like '%"+task.getState()+"%'");
		}
		//����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%' and state like '%"+task.getState()+"%'");
		}
		//����������˻����Ա𶼲�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and repairer like '%"+task.getRepairer()+"%' and state like '%"+task.getState()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	//ͳ�������¼��
	public int allTaskCount(Connection con, Task task) throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_repair where state in('��ά��','ά����','��ά��')");
		//����û�������Ϊ�գ�����Ϊ�գ����ѯ����������ļ�¼��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//���ά���߲�Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%'");
		}
		//���״̬��Ϊ�գ����ѯ����ü�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and state like '%"+task.getState()+"%'");
		}
		//����������˻�����Ϊ�յ�ʱ���Ա�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and repairer like'%"+task.getRepairer()+"%'");
		}
		//���������״̬����Ϊ�գ�ά����Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' state sex like '%"+task.getState()+"%'");
		}
		//����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%' and state like '%"+task.getState()+"%'");
		}
		//����������˻����Ա𶼲�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and repairer like '%"+task.getRepairer()+"%' and state like '%"+task.getState()+"%'");
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
	//ɾ�����޼�¼�¼�
	public int taskDel(Connection con, String delIds) throws Exception {
		String sql="delete from t_repair where taskId in("+delIds+")";
		PreparedStatement ps=con.prepareStatement(sql);
		return ps.executeUpdate();
	}
	//��ӱ�������
	public int taskAdd(Connection con,Task task) throws Exception{
		String sql="insert into t_repair(taskId,userName,publishTime,userAddress,phone,troubleDesc,state) value(null,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, task.getUserName());
		ps.setString(2, task.getPublishTime());
		ps.setString(3, task.getUserAddress());
		ps.setString(4, task.getPhone());
		ps.setString(5, task.getTroubelDesc());
		ps.setString(6, task.getState());
		return ps.executeUpdate();
	}
	
	
	//�������޼�¼�嵥��List
	public ResultSet exportTaskList(Connection con,PageBean pageBean)throws Exception{

		StringBuffer sb=new StringBuffer("select * from t_repair where state in('��ά��','ά����','��ά��')");
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		
		if(pageBean!=null){
			sb.append(" limit ?,?");			
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		if(pageBean!=null){
			pstmt.setInt(1, pageBean.getStart());
			pstmt.setInt(2, pageBean.getRows());
		}
		return pstmt.executeQuery();
	}
}
