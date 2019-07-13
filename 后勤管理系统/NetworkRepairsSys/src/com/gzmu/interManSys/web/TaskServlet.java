package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.TaskDao;
import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.JsonUtil;
import com.gzmu.interManSys.util.ResponseUtil;

public class TaskServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	TaskDao allTaskDao=new TaskDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page=request .getParameter("page");
		String rows=request.getParameter("rows");
		//从前台获取查询条件，用户名，维修者，状态等条件
		String userName=request.getParameter("userName");
		String repairer=request.getParameter("repairer");
		String state=request.getParameter("state");
		

		Task task=new Task();
		//将前台传来的用户姓名，维修者，状态等条件传到Task
		task.setUserName(userName);
		task.setRepairer(repairer);
		task.setState(state);

		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();//连接数据库
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(allTaskDao.taskList(con,pageBean,task));
			int total=allTaskDao.allTaskCount(con,task);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(response, result);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
