package cn.house.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.house.model.util.dao.employeedao;
import cn.house.model.util.servers.renshiServers;
import cn.house.model.util.servers.imple.renshiServersimple;
import cn.house.vo.employee;

/**
 * Servlet implementation class RsglServlet
 */
@WebServlet("/RsglServlet")
public class RsglServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	renshiServers userService = new renshiServersimple();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RsglServlet() {
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
			int empId = Integer.parseInt(req.getParameter("empId"));
			employeedao empssdao = new employeedao();
			empssdao.delet(empId);
			List<employee> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/admin/renshiguanli/RSGL.jsp")
					.forward(req, resp);
		} else if ("toUpdate".equals(type)) {
			int empId = Integer.parseInt(req.getParameter("empId"));
			employeedao empssdao = new employeedao();
			List<employee> userList = new ArrayList<employee>();
			userList = empssdao.querycardbyid(empId);
			for (employee bean : userList) {
				employee userVO = new employee();
				userVO.setEmpId(bean.getEmpId());
				userVO.setEmpDepartment(bean.getEmpDepartment());
				userVO.setEmpWork(bean.getEmpWork());
				userVO.setEmpName(bean.getEmpName());
				userVO.setId_card(bean.getId_card());
				userVO.setTel(bean.getTel());
				userVO.setEmpSex(bean.getEmpSex());
				userVO.setBornTime(bean.getBornTime());
				userVO.setEmpAcademic(bean.getEmpAcademic());
				userVO.setEnterTime(bean.getEnterTime());
				userVO.setWorkYears(bean.getWorkYears());
				userVO.setBornLocal(bean.getBornLocal());
				userVO.setTimeLimit(bean.getTimeLimit());

				req.setAttribute("employee", userVO);
				req.getRequestDispatcher("/html/admin/renshiguanli/xiugai.jsp")
						.forward(req, resp);
			}

		} else {

			List<employee> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/admin/renshiguanli/RSGL.jsp")
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
		int empId = Integer.parseInt(req.getParameter("empId"));
		String empDepartment = req.getParameter("textfield");
		String empWork = req.getParameter("textfield2");
		String empName = req.getParameter("textfield3");
		String id_card = req.getParameter("textfield4");
		String tel = req.getParameter("textfield5");
		String empSex = req.getParameter("textfield6");
		String bornTime = req.getParameter("textfield7");
		String empAcademic = req.getParameter("textfield8");
		String enterTime = req.getParameter("textfield9");
		String workYears = req.getParameter("textfield10");
		String bornLocal = req.getParameter("textfield11");
		String timeLimit = req.getParameter("textfield12");
		// 封装
		employee empp = new employee();
		empp.setEmpId(empId);
		empp.setEmpDepartment(empDepartment);
		empp.setEmpWork(empWork);
		empp.setEmpName(empName);
		empp.setId_card(id_card);
		empp.setTel(tel);
		empp.setEmpSex(empSex);
		empp.setBornTime(bornTime);
		empp.setEmpAcademic(empAcademic);
		empp.setEnterTime(enterTime);
		empp.setWorkYears(workYears);
		empp.setBornLocal(bornLocal);
		empp.setTimeLimit(timeLimit);
		
		if ("update".equals(type)) {
			employeedao empo = new employeedao();
			int result = empo.xiugai(empp);
			if (result > 0) {
				// 添加成功之后刷新
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

				List<employee> userList = userService.getUserList(pageNumber,
						pageSize);
				req.setAttribute("userList", userList);
				req.getRequestDispatcher("/html/admin/renshiguanli/RSGL.jsp")
						.forward(req, resp);
			} else {
				// 添加失败回到添加页面
				req.setAttribute("mes", "修改失败");
				req.getRequestDispatcher("/html/admin/renshiguanli/xiugai.jsp")
						.forward(req, resp);
			}

		} else {
			employeedao empo = new employeedao();
			int result1 = empo.increas(empp);
			if (result1 > 0) {
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

				List<employee> userList = userService.getUserList(pageNumber,
						pageSize);
				req.setAttribute("userList", userList);
				req.getRequestDispatcher("/html/admin/renshiguanli/RSGL.jsp")
						.forward(req, resp);
			} else {
				// 添加失败回到添加页面
				req.setAttribute("mes", "添加失败");
				req.getRequestDispatcher(
						"/html/admin/renshiguanli/tianjiayuangong.jsp")
						.forward(req, resp);
			}

		}
	}
}
