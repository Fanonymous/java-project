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
 * Servlet implementation class updatesideSevrlet
 */
@WebServlet("/updatesideSevrlet")
public class updatesideSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatesideSevrlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		int admi=Integer.parseInt(request.getParameter("admin"));
		String pho = request.getParameter("contact");
		String address = request.getParameter("add");
		
		site w = new site();
		w.setSiteID(id);
		w.setSiteName(name);
		w.setAdminID(admi);
		w.setAddress(address);
		w.setPhone(pho);
		
		sideDao wm = new sideDao();
		wm.update(w);
		
		request.getRequestDispatcher("/html/xiugaiside.jsp").forward(
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
