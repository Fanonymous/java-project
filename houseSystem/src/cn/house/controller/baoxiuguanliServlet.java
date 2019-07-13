package cn.house.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.house.model.util.dao.maintaindao;
import cn.house.model.util.servers.baoxiuchaxunServers;
import cn.house.model.util.servers.imple.baoxiuchaxunServersImpl;

import cn.house.vo.maintain;

/**
 * Servlet implementation class baoxiuguanliServlet
 */
@WebServlet("/baoxiuguanliServlet")
public class baoxiuguanliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	baoxiuchaxunServers userService = new baoxiuchaxunServersImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public baoxiuguanliServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int pageNumber = 1;
		String pageNumberStr = req.getParameter("pageNumber");
		if (pageNumberStr != null && !pageNumberStr.isEmpty()) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		int pageSize = 10;
		int totalNumber = userService.getEmpNumber();
		int totalPages = totalNumber / pageSize
				+ (totalNumber % pageSize > 0 ? 1 : 0);
		req.setAttribute("pageSize", pageSize);
		req.setAttribute("pageNumber", pageNumber);
		req.setAttribute("totalPages", totalPages);

		String type = req.getParameter("type");
		if ("update".equals(type)) {
			int maintainID = Integer.parseInt(req.getParameter("maintainID"));
			String shifouweixiu = req.getParameter("shifouweixiu");
			//String state = new String(shifouweixiu.getBytes("iso8859-1"),"utf-8"); 
			maintaindao empssdao = new maintaindao();
			maintain us = new maintain();
			us.setMaintainID(maintainID);
			us.setShifouweixiu(shifouweixiu);
			empssdao.xiugai(us);

		}

		List<maintain> userList = userService.getUserList(pageNumber, pageSize);
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/html/admin/baoxiuguanli/chulibaoxiu.jsp")
				.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
