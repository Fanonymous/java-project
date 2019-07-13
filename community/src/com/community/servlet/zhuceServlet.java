package com.community.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.dao.adminDaoMapper;
import com.community.entity.admin;

/**
 * Servlet implementation class zhuceServlet
 */
@WebServlet("/zhuceServlet")
public class zhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhuceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random random = new Random();
		int x1 = random.nextInt(899999);
		int x2 = x1+100000;
		String admin_number=String.valueOf(x2);
		String admin_password=req.getParameter("password");
		String admin_password1=req.getParameter("passwordAgain");
		String admin_name=req.getParameter("contact");
		String admin_phone=req.getParameter("tel");
		if(admin_password.equals(admin_password1)){
			admin ad=new admin();
			ad.setAdmin_name(admin_name);
			ad.setAdmin_number(admin_number);
			ad.setAdmin_password(admin_password1);
			ad.setAdmin_phone(admin_phone);
			if(adminDaoMapper.saveadminInfo(ad)){
				req.setAttribute("mes1", admin_number+"注册成功");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			}else{
				req.setAttribute("mes2", "注册失败！请重新注册！");
				RequestDispatcher dispatcher = req.getRequestDispatcher("zhuce.jsp");
				dispatcher.forward(req, resp);
			}
			
		}else{
			req.setAttribute("mes", "俩次输入的密码不一致，请重新输入！");
			RequestDispatcher dispatcher = req.getRequestDispatcher("zhuce.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
