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
import com.community.entity.charge;
import com.google.gson.Gson;

/**
 * Servlet implementation class chargeServlet
 */
@WebServlet("/chargeServlet")
public class chargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String m = req.getParameter("m");
		if ("findchargeWithPage".equals(m)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("page",
					(Integer.parseInt(req.getParameter("page")) - 1) * Integer.parseInt(req.getParameter("rows")));
			map.put("rows", Integer.parseInt(req.getParameter("rows")));
			map.put("status", req.getParameter("status"));
			List<charge> list = chargeDaoMapper.findchargeWithPage(map);
			int count = chargeDaoMapper.getchargeCount();
			Map<String, Object> mapData = new HashMap<String, Object>();
			mapData.put("rows", list);
			mapData.put("total", count);
			resp.getWriter().print(new Gson().toJson(mapData));
		} else if ("savechargeInfo".equals(m)) {
			charge charge=new charge();
			charge.setHouseid(req.getParameter("houseid"));
			charge.setMonth(req.getParameter("month"));
			charge.setWater(Integer.parseInt(req.getParameter("water")));
			charge.setElectric(Integer.parseInt(req.getParameter("electric")));			
			if (chargeDaoMapper.savechargeInfo(
					charge)) {
				resp.getWriter().print(true);
			} else {
				resp.getWriter().print(false);
			}
		} else if ("findchargeById".equals(m)) {
			charge charge=new charge();
			charge = chargeDaoMapper.findchargeById(Integer.parseInt(req.getParameter("fId")));
			resp.getWriter().print(new Gson().toJson(charge));
		} else if ("updatechargeInfo".equals(m)) {
			charge charge1=new charge();
			charge1.setId(Integer.parseInt(req.getParameter("id")));
			charge1.setHouseid(req.getParameter("houseid"));
			charge1.setMonth(req.getParameter("month"));
			charge1.setWater(Integer.parseInt(req.getParameter("water")));
			charge1.setElectric(Integer.parseInt(req.getParameter("electric")));
			charge1.setStatus(req.getParameter("status"));
			charge1.setRname(req.getParameter("rname"));
			charge1.setCdate(req.getParameter("cdate"));
			if (chargeDaoMapper.updatechargeInfo(charge1)) {
				resp.getWriter().print(true);
			} else {
				resp.getWriter().print(false);
			}
		}
		resp.getWriter().flush();
		resp.getWriter().close();

	}
}
