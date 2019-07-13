package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.UserDao;
import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.JsonUtil;
import com.gzmu.interManSys.util.ResponseUtil;

public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();

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
		//获取查询的 姓名，用户名，性别
		String name=request.getParameter("name");
		String userName=request.getParameter("userName");
		String sex=request.getParameter("sex");
		
		if(name==null){
			name="";
		}
		if(userName==null){
			userName="";
		}
		
		User user=new User();
		//将姓名，账号，性别，传到user
		user.setName(name);
		user.setUserName(userName);
		user.setSex(sex);
	
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		Connection con=null;
		try{
			con=dbUtil.getCon();//连接数据库
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(userDao.userList(con,pageBean,user));
			int total=userDao.userCount(con,user);
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
