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
 * Servlet implementation class renshigaunliServlet
 */
@WebServlet("/renshigaunliServlet")
public class renshigaunliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	renshiServers userService = new renshiServersimple();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public renshigaunliServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//人事登记
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


			List<employee> userList = userService.getUserList(pageNumber,
					pageSize);
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("/html/admin/renshiguanli/renshixinxi.jsp").forward(req, resp);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String type = req.getParameter("type");
		String empDepartment=req.getParameter("textfield");
		String empWork=req.getParameter("textfield2");
		String empName=req.getParameter("textfield3");
		String id_card=req.getParameter("textfield4");
		String tel=req.getParameter("textfield5");
		String empSex=req.getParameter("textfield6");
		String bornTime=req.getParameter("textfield7");
		String empAcademic=req.getParameter("textfield8");
		String enterTime=req.getParameter("textfield9");
		String workYears=req.getParameter("textfield10");
		String bornLocal=req.getParameter("textfield11");
		String timeLimit=req.getParameter("textfield12");
		//封装
		employee empp=new employee();
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
		employeedao empo=new employeedao();
		int result=empo.increas(empp);
		if(result>0){
			//添加成功之后刷新
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
				req.getRequestDispatcher("/html/admin/renshiguanli/renshixinxi.jsp").forward(req, resp);				
		}else{
			//添加失败回到添加页面
			req.setAttribute("mes", "添加失败");
			req.getRequestDispatcher("/html/admin/renshiguanli/tianjiayuangong.jsp").forward(req, resp);
		}
				
//		this.doGet(req, resp);
	}

}
