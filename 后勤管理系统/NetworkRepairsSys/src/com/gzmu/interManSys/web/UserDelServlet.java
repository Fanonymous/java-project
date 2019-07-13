
package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.UserDao;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;

public class UserDelServlet extends HttpServlet{
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
		String delIds=request.getParameter("delIds");
		Connection con=null;
		try{
			con=dbUtil.getCon();//连接数据库
			JSONObject result=new JSONObject();
			int delNums=userDao.userDel(con,delIds);//获取删除的数量
			//删除数量大于0，才说明删除成功
			if(delNums>0){
				result.put("success","true");
				result.put("delNums", delNums);
			}
			else{
				result.put("erroeMsg", "数据删除失败！");
			}
			ResponseUtil.write(response, result);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();//关闭数据库
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
