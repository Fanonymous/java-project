package com.community.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.community.dao.adminDaoMapper;
import com.community.entity.admin;

/**
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
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
		String jiumima=req.getParameter("jiumima");
		String xinmima=req.getParameter("xinmima");
		if(jiumima.equals(xinmima)){
			HttpSession session = req.getSession();
			String admin_number=(String)session.getAttribute("admin_number");
			admin ad=new admin();
			ad.setAdmin_number(admin_number);
			ad.setAdmin_password(xinmima);
			if(adminDaoMapper.updateadminInfo(ad)){
			req.setAttribute("mes1", "修改成功，请重新登录！");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);}else{
				req.setAttribute("mes2", "修改失败！");
				RequestDispatcher dispatcher = req.getRequestDispatcher("html/edit.jsp");
				dispatcher.forward(req, resp);
			}
			
		}else{
			req.setAttribute("mes", "俩次输入的密码不一致！");
			RequestDispatcher dispatcher = req.getRequestDispatcher("html/edit.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		
	}

}
