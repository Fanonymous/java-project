package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.TaskDao;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;

public class TaskSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUitl=new DbUtil();
	TaskDao taskDao=new TaskDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//异步提交处理中文乱码
		request.setCharacterEncoding("UTF-8");
		//从前台获取信息
		String userName=request.getParameter("userName");
		String publishTime=request.getParameter("publishTime");
		String userAddress=request.getParameter("userAddress");
		String phone=request.getParameter("phone");
		String troubleDesc=request.getParameter("troubleDesc");
		//String state=request.getParameter("state");
		//网络中心管理员发布任务初始状态为“待维修”,不通过前台页面传过来，Servlet自动处理为待维修。
		String state = "待维修";
	
		Task task=new Task(userName,publishTime,userAddress,phone,troubleDesc,null,null,null,null,state);
		
		Connection con=null;
		try {
			con=dbUitl.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			saveNums=taskDao.taskAdd(con, task);
			//如果从添加或者删除返回的数大于零，则说明添加或者修改成功
			if(saveNums>0){
				result.put("success", "true");
			}
			else{
				result.put("success", "true");
				result.put("errorMsg", "保存失败!");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbUitl.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
