package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.StringUtil;

public class TaskHandInDao {
	//��ʾ����ά����������Ϣ���Լ���ѯ����
	public ResultSet taskList(Connection con,PageBean pageBean, Task task,User user) throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from t_repair where state = 'ά����' and repairer like '%"+user.getMyName()+"%'");
		//����û�������Ϊ�գ�����Ϊ�գ����ѯ����������ļ�¼��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//�û���ַ��Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getUserAddress()+"%'");
		}
		//����û�����ʱ�䲻Ϊ�գ����ѯ����ü�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//��������͵�ַ����Ϊ�յ�ʱ���Ա�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like'%"+task.getUserAddress()+"%'");
		}
		//���������b����ʱ�䶼��Ϊ�գ���ַΪ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getRepairer()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//����������˻����Ա𶼲�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like '%"+task.getRepairer()+"%' and repairTime like '%"+task.getState()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	//ͳ��ά���е������¼��
	public int taskHandInDaoCount(Connection con, Task task,User user) throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_repair where state = '��ά��' and repairer like '%"+user.getMyName()+"%'");
		//����û�������Ϊ�գ�����Ϊ�գ����ѯ����������ļ�¼��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//�û���ַ��Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getUserAddress()+"%'");
		}
		//����û�����ʱ�䲻Ϊ�գ����ѯ����ü�¼������Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//��������͵�ַ����Ϊ�յ�ʱ���Ա�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like'%"+task.getUserAddress()+"%'");
		}
		//���������b����ʱ�䶼��Ϊ�գ���ַΪ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getRepairer()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//����������˻����Ա𶼲�Ϊ��
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like '%"+task.getRepairer()+"%' and repairTime like '%"+task.getState()+"%'");
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
	//�Ͻ����޵��¼����൱���޸����ʱ�䣬����״̬�ʹ�����
	public synchronized int  taskHandIn(Connection con,Task task) throws Exception{
		String sql="update t_repair set finishTime=?,state=?,dealWay=? where taskId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, task.getFinishTime());
		ps.setString(2, task.getState());
		ps.setString(3, task.getDealWay());
		ps.setInt(4, task.getTaskId());
		return ps.executeUpdate();
	}
}
