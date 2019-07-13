package com.wuliuSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wuliuSystem.entity.orderform;
import com.wuliuSystem.entity.wuliuadmin;
import com.wuliuSystem.util.dao.orderformDao;

/**
 * Servlet implementation class orderformServlet
 */
@WebServlet("/orderformServlet")
public class orderformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public orderformServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String transportType = request.getParameter("yundanleixing");
		String resisteredTime = request.getParameter("riqi");
		String sendplace = request.getParameter("fahuodidian");
		String receiveplace = request.getParameter("shouhuodidian");
		String goodsType = request.getParameter("leixing");
		String goodsNumber = request.getParameter("shuliang");
		String outNmae = request.getParameter("fahuoren");
		String outPhone = request.getParameter("fahuorendianhua");
		String inName = request.getParameter("shouhuoren");
		String inPhone = request.getParameter("shouhuorendianhua");
		int cost = Integer.parseInt(request.getParameter("yunfei"));
		String remarks = request.getParameter("beizhu");

		orderform od = new orderform();
		od.setTransportType(transportType);
		od.setResisteredTime(resisteredTime);
		od.setSendplace(sendplace);
		od.setReceiveplace(receiveplace);
		od.setGoodsType(goodsType);
		od.setGoodsNumber(goodsNumber);
		od.setOutNmae(outNmae);
		od.setOutPhone(outPhone);
		od.setInName(inName);
		od.setInPhone(inPhone);
		od.setCost(cost);
		od.setRemarks(remarks);
		
		HttpSession session = request.getSession();
		wuliuadmin e = (wuliuadmin) session.getAttribute("EMP");
		orderformDao order = new orderformDao();
		order.addOrder(od, e);
		request.getRequestDispatcher("/html/main.jsp").forward(
				request, response);

	}

}
