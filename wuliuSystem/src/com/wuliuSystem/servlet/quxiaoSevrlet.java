package com.wuliuSystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wuliuSystem.entity.orderform;
import com.wuliuSystem.util.dao.orderformDao;

/**
 * Servlet implementation class quxiaoSevrlet
 */
@WebServlet("/quxiaoSevrlet")
public class quxiaoSevrlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public quxiaoSevrlet() {
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
		String type = request.getParameter("type");
		if ("del".equals(type)) {
			int orderID = Integer.parseInt(request.getParameter("orderID"));
			orderformDao empssdao = new orderformDao();
			empssdao.delet(orderID);
			List<orderform> userList = new ArrayList<orderform>();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/html/main.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderID = request.getParameter("danhao");

		orderformDao order = new orderformDao();
		List<orderform> userList = new ArrayList<orderform>();
		userList = order.querycardbyid(orderID);
		for (orderform bean : userList) {
			orderform orde = new orderform();

			orde.setOrderID(bean.getOrderID());
			orde.setTransportType(bean.getTransportType());
			orde.setResisteredTime(bean.getResisteredTime());
			orde.setSendplace(bean.getSendplace());
			orde.setReceiveplace(bean.getReceiveplace());
			orde.setGoodsName(bean.getGoodsName());
			orde.setGoodsType(bean.getGoodsType());
			orde.setGoodsNumber(bean.getGoodsNumber());
			orde.setOutNmae(bean.getOutNmae());
			orde.setOutPhone(bean.getOutPhone());
			orde.setInName(bean.getInName());
			orde.setInPhone(bean.getInPhone());
			orde.setCost(bean.getCost());
			orde.setRemarks(bean.getRemarks());

			request.setAttribute("orderform", userList);
			request.getRequestDispatcher("/html/quxiao.jsp").forward(request, response);

		}
	}
}
