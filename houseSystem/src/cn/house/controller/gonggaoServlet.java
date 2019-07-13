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
import cn.house.model.util.servers.gonggaoServers;

import cn.house.model.util.servers.imple.gongaoServersImp;

import cn.house.vo.gonggao;

/**
 * Servlet implementation class gonggaoServlet
 */
@WebServlet("/gonggaoServlet")
public class gonggaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	gonggaoServers userService = new gongaoServersImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public gonggaoServlet() {
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
			int ggId = Integer.parseInt(req.getParameter("ggId"));
			gonggaodao empssdao = new gonggaodao();
			empssdao.delet(ggId);
			List<gonggao> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/admin/wuyeguanli/xiaoqugonggao.jsp")
					.forward(req, resp);
		} else if ("toUpdate".equals(type)) {
			int ggId = Integer.parseInt(req.getParameter("ggId"));
			gonggaodao empssdao = new gonggaodao();

			List<gonggao> userList = new ArrayList<gonggao>();
			userList = empssdao.querycardbyid(ggId);
			for (gonggao bean : userList) {
				gonggao userVO = new gonggao();
				userVO.setGgId(bean.getGgId());
				userVO.setGg(bean.getGg());
				req.setAttribute("gonggao", userVO);
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xiugaigonggao.jsp").forward(
						req, resp);
			}
		} else {

			List<gonggao> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/admin/wuyeguanli/xiaoqugonggao.jsp")
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
		//int ggId = Integer.parseInt(req.getParameter("ggId"));
		String gG = req.getParameter("textarea");
		gonggao gao = new gonggao();
		gao.setGg(gG);
		//gao.setGgId(ggId);
		if ("update".equals(type)) {
			gonggaodao gaodao = new gonggaodao();
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
				List<gonggao> userList = userService.getUserList(pageNumber,
						pageSize);
				req.setAttribute("userList", userList);
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xiaoqugonggao.jsp").forward(
						req, resp);

			} else {
				// 添加失败回到修改页面
				req.setAttribute("mes", "修改失败");
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xiugaigonggao.jsp").forward(req,
						resp);
			}

		} else {
			gonggaodao gaodao = new gonggaodao();
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
				List<gonggao> userList = userService.getUserList(pageNumber,
						pageSize);
				req.setAttribute("userList", userList);
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/xiaoqugonggao.jsp").forward(
						req, resp);

			} else {
				// 添加失败回到添加页面
				req.setAttribute("mes", "添加失败");
				req.getRequestDispatcher(
						"/html/admin/wuyeguanli/tianjiagonggao.jsp").forward(
						req, resp);
			}

		}
	}
}
