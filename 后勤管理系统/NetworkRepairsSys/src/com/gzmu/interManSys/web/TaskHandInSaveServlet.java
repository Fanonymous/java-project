package com.gzmu.interManSys.web;
//上交任务保存的servlet，相当于修改维修记录的状态
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.TaskHandInDao;
import com.gzmu.interManSys.model.Task;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;
import com.gzmu.interManSys.util.StringUtil;

public class TaskHandInSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUitl=new DbUtil();
	TaskHandInDao taskHandInDao=new TaskHandInDao();
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
		String finishTime=request.getParameter("finishTime");
		String dealWay=request.getParameter("dealWay");
		String taskId=request.getParameter("taskId");
		
		//状态不通过前台传过来，在Servlet中自动将上交任务的状态处理为“已维修”
		String state = "已维修";
		
		Task task=new Task(null,null,null,null,null,null,null,finishTime,dealWay,state);
		
		//如果前台传来的ID不为空，将ID转为int数据类型
		if(StringUtil.isNotEmpty(taskId)){
			task.setTaskId(Integer.parseInt(taskId));
		}
		Connection con=null;
		try {
			con=dbUitl.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			//上交任务事件
			saveNums=taskHandInDao.taskHandIn(con, task);
			//上交任务事件返回的值大于零，上交成功
			if(saveNums>0){
				result.put("success", "true");
			}
			else{
				result.put("success", "true");
				result.put("errorMsg", "上交失败!");
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
