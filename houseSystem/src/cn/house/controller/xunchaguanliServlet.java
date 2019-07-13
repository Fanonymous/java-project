package cn.house.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.house.model.util.dao.gonggaodao;
import cn.house.model.util.dao.xunchadao;
import cn.house.model.util.servers.xunchaServers;
import cn.house.model.util.servers.imple.xunchaServersImP;
import cn.house.vo.gonggao;
import cn.house.vo.xuncha;

/**
 * Servlet implementation class xunchaguanliServlet
 */
@WebServlet("/xunchaguanliServlet")
public class xunchaguanliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	xunchaServers userService = new xunchaServersImP();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xunchaguanliServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
		if ("del".equals(type)) {
			int xunchaID = Integer.parseInt(req.getParameter("xunchaID"));
			xunchadao empssdao = new xunchadao();
			empssdao.delet(xunchaID);
			List<xuncha> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/admin/wuyeguanli/xunchaguanli.jsp")
					.forward(req, resp);
		} else if ("toUpdate".equals(type)) {
			int xunchaID = Integer.parseInt(req.getParameter("xunchaID"));
			xunchadao empssdao = new xunchadao();

			List<xuncha> userList = new ArrayList<xuncha>();
			userList = empssdao.querycardbyid(xunchaID);
			for (xuncha bean : userList) {
				xuncha userVO = new xuncha();
				userVO.setXunchaID(bean.getXunchaID());
				userVO.setXuncha_person(bean.getXuncha_person());
				userVO.setXuncha_type(bean.getXuncha_type());
				userVO.setXuncha_time(bean.getXuncha_time());
				userVO.setXuncha_chuliren(bean.getXuncha_chuliren());
				userVO.setXuncha_dangshiren(bean.getXuncha_dangshiren());
				userVO.setXuncha_result(bean.getXuncha_result());
				userVO.setXuncha_memo(bean.getXuncha_memo());

				req.setAttribute("xuncha", userVO);
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xiugaixuncha.jsp").forward(req,
						resp);
			}
		} else {

			List<xuncha> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/admin/wuyeguanli/xunchaguanli.jsp")
					.forward(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String type = req.getParameter("type");
		//int xunchaID = Integer.parseInt(req.getParameter("xunchaID"));
		String xuncha_person = req.getParameter("textfield");
		String xuncha_type = req.getParameter("textfield2");
		String xuncha_time = req.getParameter("textfield3");
		String xuncha_chuliren = req.getParameter("textfield4");
		String xuncha_dangshiren = req.getParameter("textfield5");
		String xuncha_result = req.getParameter("textfield6");
		String xuncha_memo = req.getParameter("textfield7");
		xuncha gao = new xuncha();
		//gao.setXunchaID(xunchaID);
		gao.setXuncha_person(xuncha_person);
		gao.setXuncha_type(xuncha_type);
		gao.setXuncha_time(xuncha_time);
		gao.setXuncha_chuliren(xuncha_chuliren);
		gao.setXuncha_dangshiren(xuncha_dangshiren);
		gao.setXuncha_result(xuncha_result);
		gao.setXuncha_memo(xuncha_memo);
		

		if ("update".equals(type)) {
			xunchadao gaodao = new xunchadao();
			int result = gaodao.xiugai(gao);
			if (result > 0) {
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
				List<xuncha> userList = userService.getUserList(pageNumber,
						pageSize);
				req.setAttribute("userList", userList);
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xunchaguanli.jsp").forward(req,
						resp);

			} else {
				// 添加失败回到添加页面
				req.setAttribute("mes", "修改失败");
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xiugaixuncha.jsp").forward(req,
						resp);
			}

		} else {
			xunchadao gaodao = new xunchadao();
			int result = gaodao.increas(gao);
			if (result > 0) {
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
				List<xuncha> userList = userService.getUserList(pageNumber,
						pageSize);
				req.setAttribute("userList", userList);
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xunchaguanli.jsp").forward(req,
						resp);

			} else {
				// 添加失败回到添加页面
				req.setAttribute("mes", "添加失败");
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/tianjiaxuncha.jsp").forward(
						req, resp);
			}

		}

	}

}
