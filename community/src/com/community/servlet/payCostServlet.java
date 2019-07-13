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


import com.community.dao.chargeDaoMapper;
import com.community.dao.payCostDaoMapper;

import com.community.entity.charge;
import com.community.entity.payCost;

/**
 * Servlet implementation class payCostServlet
 */
@WebServlet("/payCostServlet")
public class payCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payCostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		payCost pay=new payCost();
		String houseid=req.getParameter("houseid");
		pay.setHouseid(houseid);
		int total=Integer.parseInt(req.getParameter("totalcost"));
		pay.setTotalcost(total);
		pay.setRname(req.getParameter("rname"));
		pay.setCdate(req.getParameter("cdate"));
		if(payCostDaoMapper.savepayCostInfo(pay)){
			//成功缴费之后将总费用和charge表中的水费和电费俩个字段比较，如果相等就把缴费状态字段置为“已交费”
			//Map<String, Object> map = new HashMap<String, Object>();
			//map.put("houseid", houseid);
			charge ca=chargeDaoMapper.findchargeByhouseid(houseid);
				
			int water=ca.getWater();
			int electric=ca.getElectric();
			int totalMoney=water+electric;
			
			charge charge1=new charge();
			charge1.setHouseid(houseid);
			if(totalMoney<=total){
				charge1.setStatus("已缴费");
			}else{
				charge1.setStatus("欠费");
			}			
			charge1.setRname(req.getParameter("rname"));
			charge1.setCdate(req.getParameter("cdate"));
			chargeDaoMapper.updatechargeByhouseid(charge1);
			req.setAttribute("mes", "缴费成功");
			resp.sendRedirect("html/charge.jsp");		
		}else{
			req.setAttribute("mes1", "缴费失败");
			resp.sendRedirect("html/payCost.jsp");	
		}
	}

}
