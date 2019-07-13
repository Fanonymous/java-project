package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.PersonInfoModifyDao;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DateUtil;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;
import com.gzmu.interManSys.util.StringUtil;

public class PersonInfoSaveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	PersonInfoModifyDao psersonInfoModify=new PersonInfoModifyDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//异步处理中文乱码
		request.setCharacterEncoding("UTF-8");
		//从前台获取个人修改 的信息
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String grade=request.getParameter("grade");
		String major=request.getParameter("major");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String id =request.getParameter("id");
		//判断传来的生日是否为空，为空就给他一个日期样子的字符串，该字符串表示信息没有填写日期
		if(StringUtil.isEmpty(birthday)){
			birthday="0001-01-01";
		}
		User user=null;
		try {
			user=new User(null,null,null,name,sex,DateUtil.formaString(birthday, "yyyy-MM-dd"),grade,major,phone,address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//如果前台传来的ID不为空，将ID转为int数据类型
		if(StringUtil.isNotEmpty(id)){
			user.setUserId(Integer.parseInt(id));
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			saveNums=psersonInfoModify.personInfoModify(con, user);
			//如果修改的数大于零，当然只可能等于零
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
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
