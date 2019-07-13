package cn.house.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.house.model.util.servers.gonggaoServers;
import cn.house.model.util.servers.imple.gongaoServersImp;
import cn.house.vo.gonggao;

/**
 * Servlet implementation class yezhuchaxungonggaoServlet
 */
@WebServlet("/yezhuchaxungonggaoServlet")
public class yezhuchaxungonggaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	gonggaoServers userService = new gongaoServersImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   public yezhuchaxungonggaoServlet(){
	   super();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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

			List<gonggao> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/yezhu/xiaoqugonggao.jsp").forward(req, resp);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
	}

}
