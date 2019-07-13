package com.gzmu.interManSys.web;
//接收任务的servlet，相当于修改维修记录的状态
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.TaskReceiveDao;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;
import com.gzmu.interManSys.util.StringUtil;

public class TaskReceiveSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUitl=new DbUtil();
	TaskReceiveDao taskReceiveDao=new TaskReceiveDao();
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
		//从前台获取信息,报修时间点，报修者，状态，状态为维修中
		String repairTime=request.getParameter("repairTime");
		//String repairer=request.getParameter("repairer");
		String taskId=request.getParameter("taskId");
		
		//职员接收任务时，状态是不从前台填写表单中传来，而是Servlet自行处理成“维修中”传到数据库中进行修改
		String state = "维修中";
		//同理,职员填写维修表单时候维修者选项不通过前台填写，而是通过session中的登录用户名填写到数据库
		//可以从session中取出myName
		HttpSession session=request.getSession();
		String repairer = (String) session.getAttribute("myName");

		System.out.println("用户："+repairer);
		
		Task task=new Task(null,null,null,null,null,repairer,repairTime,null,null,state);
		//如果前台传来的ID不为空，将ID转为int数据类型
		if(StringUtil.isNotEmpty(taskId)){
			task.setTaskId(Integer.parseInt(taskId));
		}
		Connection con=null;
		try {
			con=dbUitl.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			//接收任务事件
			saveNums=taskReceiveDao.taskReceive(con, task);
			//如果从添加或者删除返回的数大于零，则说明接收报修任务改成功
			if(saveNums>0){
				result.put("success", "true");
			}
			else{
				result.put("success", "true");
				result.put("errorMsg", "报修失败!");
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
