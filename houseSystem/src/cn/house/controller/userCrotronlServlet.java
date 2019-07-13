package cn.house.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.house.model.util.dao.custom_accountdao;
import cn.house.vo.custom_account;

/**
 * Servlet implementation class userCrotronlServlet
 */
/****
 * 操作用户界面
 */
@WebServlet("/userCrotronlServlet")
public class userCrotronlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userCrotronlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用户修改密码
		int num = Integer.parseInt(request.getParameter("textfield2"));
		String password = new String(request.getParameter("textfield"));
		custom_account cus=new custom_account();
		cus.setCcustom_accountID(num);
		cus.setCustom_password(password);
		custom_accountdao cust=new custom_accountdao();
		int result=cust.gaimi(cus);
		if(result>0){
			request.setAttribute("mes", "修改密码成功，请重新登录！");
			request.getRequestDispatcher("/html/index.jsp").forward(request, response);	
		}else{
			request.setAttribute("mess", "账户不存在！修改失败，请重新输入");
			request.getRequestDispatcher("/html/yezhu/xiugaimima.jsp").forward(request, response);
		}
		
		
		
	}

}
