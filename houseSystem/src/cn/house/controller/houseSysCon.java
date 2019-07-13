package cn.house.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.house.model.util.dao.adminDao;
import cn.house.model.util.dao.custom_accountdao;
import cn.house.vo.custom_account;

/**
 * Servlet implementation class houseSysCon
 */
@WebServlet("/houseSysCon")
public class houseSysCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public houseSysCon() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("html/index.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 管理员登录成功跳转主页
		if ("1".equals(request.getParameter("rule"))) {

			int num = Integer.parseInt(request.getParameter("accout"));
			String password = new String(request.getParameter("pass"));
			adminDao admi = new adminDao();
			boolean boo = admi.login(num, password);
			if (boo) {
				request.getRequestDispatcher("/html/admin/indexset.jsp").forward(
						request, response);
			} else {
				// 登录不成功
				request.setAttribute("mes", "用户名或密码错误！");
				request.getRequestDispatcher("/html/index.jsp").forward(
						request, response);

			}
		} else{
			int num1 = Integer.parseInt(request.getParameter("accout"));
			String password1 = new String(request.getParameter("pass"));
			custom_accountdao cus = new custom_accountdao();
			boolean boo = cus.login(num1, password1);
			// 业主登录成功跳转主页
			if (boo) {
				request.getRequestDispatcher("/html/yezhu/topFrameset.jsp").forward(
						request, response);

			} else {
				// 不成功提示
				request.setAttribute("mes", "用户名或密码错误！");
				request.getRequestDispatcher("/html/index.jsp").forward(
						request, response);

			}

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

}
