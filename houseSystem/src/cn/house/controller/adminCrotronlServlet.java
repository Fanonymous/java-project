package cn.house.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.house.model.util.dao.adminDao;
import cn.house.model.util.dao.custom_accountdao;
import cn.house.vo.admin;
import cn.house.vo.custom_account;

/**
 * Servlet implementation class adminCrotronlServlet
 */
@WebServlet("/adminCrotronlServlet")
public class adminCrotronlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * ��������Ա��ҳ
     * @see HttpServlet#HttpServlet()
     */
    public adminCrotronlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("textfield2"));
		String password = new String(request.getParameter("textfield"));
		admin cus=new admin();
		cus.setAdminId(num);
		cus.setAdmin_password(password);
		adminDao cust=new adminDao();
		int result=cust.gaimi(cus);
		if(result>0){
			request.setAttribute("mes", "�޸�����ɹ��������µ�¼��");
			request.getRequestDispatcher("/html/index.jsp").forward(request, response);	
		}else{
			request.setAttribute("mess", "�˻������ڣ��޸�ʧ�ܣ�����������");
			request.getRequestDispatcher("/html/admin/xiugaimima.jsp").forward(request, response);
		}
	}

}
