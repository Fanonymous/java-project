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

import com.community.dao.houseDaoMapper;
import com.community.dao.ownerDaoMapper;
import com.community.entity.house;
import com.google.gson.Gson;

/**
 * Servlet implementation class houseServlet
 */
@WebServlet("/houseServlet")
public class houseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static house house;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String m=req.getParameter("m");
		resp.setCharacterEncoding("utf-8");
		if("findhouseWithPage".equals(m)){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("page", (Integer.parseInt(req.getParameter("page"))-1)*Integer.parseInt(req.getParameter("rows")));
			map.put("rows", Integer.parseInt(req.getParameter("rows")));
			List<house>list=houseDaoMapper.findhouseWithPage(map);
			
			int count=houseDaoMapper.gethouseCount();
			Map<String,Object>mapData=new HashMap<String,Object>();
			mapData.put("rows", list);
			mapData.put("total", count);
			resp.getWriter().print(new Gson().toJson(mapData));
		}else if("savehouseInfo".equals(m)){
			if(houseDaoMapper.savehouseInfo(new house(
				
					req.getParameter("houseid"), 
					Integer.parseInt(req.getParameter("floorid")),
					req.getParameter("shape"), 
					req.getParameter("area"), 
					req.getParameter("ownername"),
					Integer.parseInt(req.getParameter("people")),
					req.getParameter("ownerphone"),
					req.getParameter("mdate")
					))){
				resp.getWriter().print(true);
			}else{
				resp.getWriter().print(false);
			}
		}else if("delhouseInfo".equals(m)){
			String []arrayIds=req.getParameterValues("stuId[]");
			boolean f=false;
			for(String id :arrayIds){
				if(houseDaoMapper.delhouseInfo(Integer.parseInt(id))){
					 f=true;
				}
			}
			resp.getWriter().print(new Gson().toJson(f));
			
		}else if("findhouseById".equals(m)){
			house=houseDaoMapper.findownerById(Integer.parseInt(req.getParameter("fId")));
			resp.getWriter().print(new Gson().toJson(house));
		}else if("updatehouseInfo".equals(m)){
			//gai
			house.setHouseid(req.getParameter("houseid"));
			house.setFloorid(Integer.parseInt(req.getParameter("floorid")));;
			house.setShape(req.getParameter("shape"));
			house.setArea(req.getParameter("area"));
			house.setOwnername(req.getParameter("ownername"));
			house.setPeople(Integer.parseInt(req.getParameter("people")));
			house.setOwnerphone(req.getParameter("ownerphone"));
			house.setMdate(req.getParameter("mdate"));
			if(houseDaoMapper.updatehouseInfo(house)){
				resp.getWriter().print(true);
			}else{
				resp.getWriter().print(false);
			}
		}
		resp.getWriter().flush();
		resp.getWriter().close();
	}
}
