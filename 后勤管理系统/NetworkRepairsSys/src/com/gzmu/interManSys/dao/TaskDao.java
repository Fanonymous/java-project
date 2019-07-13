package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.StringUtil;

public class TaskDao {
	//显示所有任务信息，以及查询功能
	public ResultSet taskList(Connection con,PageBean pageBean, Task task) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_repair where state in('待维修','维修中','已维修')");
		//如果用户姓名不为空，其他为空，则查询满足该姓名的记录，
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//如果维护者不为空，则查询满足该 账号的记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%'");
		}
		//如果状态不为空，则查询满足该记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and state like '%"+task.getState()+"%'");
		}
		//如果姓名和账户都不为空的时候，性别为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and repairer like'%"+task.getRepairer()+"%'");
		}
		//如果姓名和状态都不为空，维护者为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' and state like '%"+task.getState()+"%'");
		}
		//如果账户和性别都不为空，姓名为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%' and state like '%"+task.getState()+"%'");
		}
		//如果姓名，账户，性别都不为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and repairer like '%"+task.getRepairer()+"%' and state like '%"+task.getState()+"%'");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	//统计任务记录数
	public int allTaskCount(Connection con, Task task) throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_repair where state in('待维修','维修中','已维修')");
		//如果用户姓名不为空，其他为空，则查询满足该姓名的记录，
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%'");
		}
		//如果维护者不为空，则查询满足该 账号的记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%'");
		}
		//如果状态不为空，则查询满足该记录，其他为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and state like '%"+task.getState()+"%'");
		}
		//如果姓名和账户都不为空的时候，性别为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isEmpty(task.getState())){
			sb.append(" and userName like '%"+task.getUserName()+"%' and repairer like'%"+task.getRepairer()+"%'");
		}
		//如果姓名和状态都不为空，维护者为空
		if(StringUtil.isNotEmpty(task.getUserName()) && StringUtil.isEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and usreName like '%"+task.getUserName()+"%' state sex like '%"+task.getState()+"%'");
		}
		//如果账户和性别都不为空，姓名为空
		if(StringUtil.isEmpty(task.getUserName()) && StringUtil.isNotEmpty(task.getRepairer()) && StringUtil.isNotEmpty(task.getState())){
			sb.append(" and repairer like '%"+task.getRepairer()+"%' and state like '%"+task.getState()+"%'");
		}
		//如果姓名，账户，性别都不为空
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
	//删除报修记录事件
	public int taskDel(Connection con, String delIds) throws Exception {
		String sql="delete from t_repair where taskId in("+delIds+")";
		PreparedStatement ps=con.prepareStatement(sql);
		return ps.executeUpdate();
	}
	//添加报修任务
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
	
	
	//导出报修记录清单的List
	public ResultSet exportTaskList(Connection con,PageBean pageBean)throws Exception{

		StringBuffer sb=new StringBuffer("select * from t_repair where state in('待维修','维修中','已维修')");
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
