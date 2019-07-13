package com.wuliuSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wuliuSystem.entity.wuliuadmin;
import com.wuliuSystem.util.dao.wuliuadminDao;

/**
 * Servlet implementation class adminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("name");		
		String password=request.getParameter("password");
		
		
		wuliuadminDao wuliu=new wuliuadminDao();
		wuliuadmin admi=wuliu.loginadmin(id, password);
		
		if(admi==null){
			request.setAttribute("mes", "用户名或密码错误");
			response.sendRedirect("index.jsp");
			
		}else{
			HttpSession session = request.getSession(true);
			session.setAttribute("EMP", admi);
			request.getRequestDispatcher("/html/main.jsp").forward(
					request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
