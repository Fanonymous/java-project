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

import com.community.dao.ownerDaoMapper;
import com.community.entity.owner;
import com.google.gson.Gson;

/**
 * Servlet implementation class ownerServlet
 */
@WebServlet("/ownerServlet")
public class ownerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static owner owner;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String m=req.getParameter("m");
		resp.setCharacterEncoding("utf-8");
		if("findownerWithPage".equals(m)){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("page", (Integer.parseInt(req.getParameter("page"))-1)*Integer.parseInt(req.getParameter("rows")));
			map.put("rows", Integer.parseInt(req.getParameter("rows")));
			List<owner>list=ownerDaoMapper.findownerWithPage(map);
			
			int count=ownerDaoMapper.getownerCount();
			Map<String,Object>mapData=new HashMap<String,Object>();
			mapData.put("rows", list);
			mapData.put("total", count);
			resp.getWriter().print(new Gson().toJson(mapData));
		}else if("saveownerInfo".equals(m)){
			if(ownerDaoMapper.saveownerInfo(new owner(
					req.getParameter("owner_name"), 
					req.getParameter("owner_idcard"),
					req.getParameter("owner_sex"), 
					req.getParameter("owner_phone"), 
					req.getParameter("owner_workstation"),
					req.getParameter("houseid"),
					Integer.parseInt(req.getParameter("floorid"))))){
				resp.getWriter().print(true);
			}else{
				resp.getWriter().print(false);
			}
		}else if("delownerInfo".equals(m)){
			String []arrayIds=req.getParameterValues("stuId[]");
			boolean f=false;
			for(String id :arrayIds){
				if(ownerDaoMapper.delownerInfo(Integer.parseInt(id))){
					 f=true;
				}
			}
			resp.getWriter().print(new Gson().toJson(f));
			
		}else if("findownerById".equals(m)){
			owner=ownerDaoMapper.findownerById(Integer.parseInt(req.getParameter("fId")));
			resp.getWriter().print(new Gson().toJson(owner));
		}else if("updateownerInfo".equals(m)){
			owner.setOwner_name(req.getParameter("owner_name"));
			owner.setOwner_idcard(req.getParameter("owner_idcard"));;
			owner.setOwner_sex(req.getParameter("owner_sex"));
			owner.setOwner_phone(req.getParameter("owner_phone"));
			owner.setOwner_workstation(req.getParameter("owner_workstation"));
			owner.setHouseid(req.getParameter("houseid"));
			owner.setFloorid(Integer.parseInt(req.getParameter("floorid")));
			if(ownerDaoMapper.updateownerInfo(owner)){
				resp.getWriter().print(true);
			}else{
				resp.getWriter().print(false);
			}
		}
		resp.getWriter().flush();
		resp.getWriter().close();
	}
}
