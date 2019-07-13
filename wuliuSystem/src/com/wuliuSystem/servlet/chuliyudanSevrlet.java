package com.wuliuSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wuliuSystem.entity.wuliuMessage;
import com.wuliuSystem.entity.wuliuadmin;
import com.wuliuSystem.util.dao.wuliuMessageDao;

/**
 * Servlet implementation class chuliyudanSevrlet
 */
@WebServlet("/chuliyudanSevrlet")
public class chuliyudanSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chuliyudanSevrlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderID= request.getParameter("orderID");
		String opr=request.getParameter("opr");
		String remarks=request.getParameter("remarks");
		HttpSession session = request.getSession();
		wuliuadmin e = (wuliuadmin) session.getAttribute("EMP");
		wuliuMessage me=new wuliuMessage();
		me.setOrderID(orderID);
		me.setAdminID(e.getAdminID());
		me.setSideID(e.getSiteID());
		me.setGoodstatus(opr);
		me.setRemarks(remarks);
		wuliuMessageDao mes=new wuliuMessageDao();
		mes.add(me);
		request.getRequestDispatcher("/html/chuliyundan.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
