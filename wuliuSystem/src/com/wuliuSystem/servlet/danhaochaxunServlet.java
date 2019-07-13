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
 * Servlet implementation class danhaochaxunServlet
 */
@WebServlet("/danhaochaxunServlet")
public class danhaochaxunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public danhaochaxunServlet() {
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
			request.getRequestDispatcher("/html/xianshi.jsp").forward(request, response);
	
		}
}
}
