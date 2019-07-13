package com.gzmu.interManSys.web;
import com.gzmu.interManSys.dao.TaskHandInDao;
import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.JsonUtil;
import com.gzmu.interManSys.util.ResponseUtil;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TaskHandInServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	TaskHandInDao taskHandInDao=new TaskHandInDao();
	DbUtil dbUtil=new DbUtil();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从前台获取查询条件值，用户名，维修者维修时间，用户地址
		String userName=request.getParameter("userName");
		String repairtime=request.getParameter("repairTime");
		String userAddress=request.getParameter("userAddress");
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		
		//从session中获取登录的userName
		HttpSession session=request.getSession();
		String currentUser=(String) session.getAttribute("myName");
		
		//将session中获取的userName传到user里面
		User user=new User();
		user.setMyName(currentUser);
		
		Task task=new Task();
		//将前台传来的查询条件值，用户名，用户报修时间，用户地址传到task里面
		task.setUserName(userName);
		task.setRepairTime(repairtime);
		task.setUserAddress(userAddress);
		
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();//连接数据库
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(taskHandInDao.taskList(con, pageBean, task,user));
			int total=taskHandInDao.taskHandInDaoCount(con, task, user);
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
