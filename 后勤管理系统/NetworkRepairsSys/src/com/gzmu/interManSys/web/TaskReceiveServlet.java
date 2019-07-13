package com.gzmu.interManSys.web;
import com.gzmu.interManSys.dao.TaskReceiveDao;
import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.JsonUtil;
import com.gzmu.interManSys.util.ResponseUtil;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TaskReceiveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	TaskReceiveDao taskReceiveDao=new TaskReceiveDao();
	DbUtil dbUtil=new DbUtil();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从前台获取查询条件值，用户名，用户报修时间，用户地址
		String userName=request.getParameter("userName");
		String publishTime=request.getParameter("publishTime");
		String userAddress=request.getParameter("userAddress");
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		Task task=new Task();
		
		//将前台传来的查询条件值，用户名，用户报修时间，用户地址传到task里面
		task.setUserName(userName);
		task.setPublishTime(publishTime);
		task.setUserAddress(userAddress);
		
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();//连接数据库
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(taskReceiveDao.taskList(con, pageBean, task));
			int total=taskReceiveDao.taskReceiveCount(con, task);
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
