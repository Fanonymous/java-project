package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.UserDao;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DateUtil;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;
import com.gzmu.interManSys.util.StringUtil;

public class UserSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbUtil dbUitl=new DbUtil();
	UserDao userDao=new UserDao();
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
		String password=request.getParameter("password");
		String level=request.getParameter("level");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String grade=request.getParameter("grade");
		String major=request.getParameter("major");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String id=request.getParameter("id");
		if(StringUtil.isEmpty(birthday)){
			birthday="0001-01-01";
		}
		User user=null;
	
		try {
			user=new User(userName,password,level,name,sex,DateUtil.formaString(birthday, "yyyy-MM-dd"),grade,major,phone,address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//如果前台传来的ID不为空，将ID转为int数据类型
		if(StringUtil.isNotEmpty(id)){
			user.setUserId(Integer.parseInt(id));
		}
		Connection con=null;
		try {
			con=dbUitl.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			//如果传来的id不为空，则说明是修改事件
			if(StringUtil.isNotEmpty(id)){
				saveNums=userDao.userUpdate(con, user);
			}
			//那么就是，添加事件
			else{
				saveNums=userDao.userAdd(con, user);
			}
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
