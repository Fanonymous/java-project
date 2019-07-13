package com.community.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.community.dao.adminDaoMapper;
import com.community.entity.admin;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String m = req.getParameter("m");
		HttpSession session = req.getSession();
		if ("login".equals(m)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("admin_number", req.getParameter("username"));
			map.put("admin_password", req.getParameter("password"));
			session.setAttribute("admin_number", req.getParameter("username"));
			if (adminDaoMapper.login(map)) {
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("admin_number", req.getParameter("username"));
				List<admin> list=adminDaoMapper.findadminWithPage(map1);
				for(admin ad:list){
					admin adm=new admin();
					adm.setAdmin_number(ad.getAdmin_number());
					adm.setAdmin_password(ad.getAdmin_password());
					adm.setAdmin_name(ad.getAdmin_name());
					adm.setAdmin_phone(ad.getAdmin_phone());
					session.setAttribute("name",adm.getAdmin_name());
				}
				
				resp.getWriter().print(true);
			} else {
				resp.getWriter().print(false);
			}
		}
	}
}
