package com.wuliuSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuliuSystem.entity.site;
import com.wuliuSystem.util.dao.sideDao;

/**
 * Servlet implementation class sideaddSevrlet
 */
@WebServlet("/sideaddSevrlet")
public class sideaddSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sideaddSevrlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pho = request.getParameter("contact");
		String address = request.getParameter("add");
		int admin=Integer.parseInt(request.getParameter("admin"));
		
		site w = new site();
		w.setAdminID(admin);
		w.setSiteName(name);
		w.setAddress(address);
		w.setPhone(pho);
		
		sideDao wm = new sideDao();
		wm.add(w);
		
		request.getRequestDispatcher("/html/side_list.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
