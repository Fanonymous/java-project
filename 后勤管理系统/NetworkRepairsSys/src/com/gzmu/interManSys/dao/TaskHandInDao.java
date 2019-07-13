package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.StringUtil;

public class TaskHandInDao {
	//显示所有维修中任务信息，以及查询功能
	public ResultSet taskList(Connection con,PageBean pageBean, Task task,User user) throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from t_repair where state = '维修中' and repairer like '%"+user.getMyName()+"%'");
		//如果用户姓名不为空，其他为空，则查询满足该姓名的记录，
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//用户地址不为空，则查询满足该 账号的记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getUserAddress()+"%'");
		}
		//如果用户报修时间不为空，则查询满足该记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//如果姓名和地址都不为空的时候，性别为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like'%"+task.getUserAddress()+"%'");
		}
		//如果姓名和b报修时间都不为空，地址为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//如果账户和性别都不为空，姓名为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getRepairer()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//如果姓名，账户，性别都不为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like '%"+task.getRepairer()+"%' and repairTime like '%"+task.getState()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	//统计维修中的任务记录数
	public int taskHandInDaoCount(Connection con, Task task,User user) throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_repair where state = '待维修' and repairer like '%"+user.getMyName()+"%'");
		//如果用户姓名不为空，其他为空，则查询满足该姓名的记录，
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//用户地址不为空，则查询满足该 账号的记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getUserAddress()+"%'");
		}
		//如果用户报修时间不为空，则查询满足该记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//如果姓名和地址都不为空的时候，性别为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserAddress()) && StringUtil.isEmpty(task.getRepairTime())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and userAddress like'%"+task.getUserAddress()+"%'");
		}
		//如果姓名和b报修时间都不为空，地址为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getUserAddress()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//如果账户和性别都不为空，姓名为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairTime())){
			sb.append(" and userAddress like '%"+task.getRepairer()+"%' and repairTime like '%"+task.getRepairTime()+"%'");
		}
		//如果姓名，账户，性别都不为空
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
	//上交报修单事件，相当于修改完成时间，报修状态和处理方法
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
