package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gzmu.interManSys.dao.UserDao;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.StringUtil;

public class LoginServlet extends HttpServlet{
															
	private static final long serialVersionUID = 1L;
	UserDao userDao=new UserDao();
	DbUtil dbUtil=new DbUtil();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//定义“管理员字符串?作为权限判断，判断前台传来的权限是否和他相同
		 String currentLevel="1";
		
		/*从前台获取用户名，密码，权限*/
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String level=request.getParameter("level");
		//System.out.println(level);
		
		//request.setAttribute("userName", userName);
		//request.setAttribute("password", password);
		request.setCharacterEncoding("UTF-8");
		
		/*判断用户名和密码是否为空*/
		if(StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)){
			request.setAttribute("error", "用户名或密码不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	
		//将用户名，密码，权限参数传过?
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setLevel(level);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			User currentUser=userDao.login(con,user);
			//userDao.login(con,user)返回的User对象为null，则说明在数据库里面没有这条记录
			if(currentUser == null){
				request.setAttribute("error", "用户名或密码错误，或者权限不匹配");
				//服务器跳转，登录失失败
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else{
				
				//服务器重定向，登录成功
				HttpSession session = request.getSession();
				session.setAttribute("currentUser",currentUser);
				//将登录的用户名缓存到myName�?
				session.setAttribute("myName", currentUser.getUserName());
				//判断权限，如果是管理员，则跳到index.jsp
				if(currentUser.getLevel().equals(currentLevel)){
					response.sendRedirect("index.jsp");
				}
				//如果是别的（职员），则跳到index1.jsp
				else if((currentUser.getLevel().equals("2"))){
					response.sendRedirect("index1.jsp");
				}
				else{
					response.sendRedirect("taskManage2.jsp");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
