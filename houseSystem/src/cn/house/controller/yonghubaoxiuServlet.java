package cn.house.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.house.model.util.dao.maintaindao;
import cn.house.vo.maintain;

/**
 * Servlet implementation class yonghubaoxiuServlet
 */
@WebServlet("/yonghubaoxiuServlet")
public class yonghubaoxiuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yonghubaoxiuServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String maintain_thing=request.getParameter("textarea");
		String maintain_homesnumber=request.getParameter("textfield");
		String maintain_fh=request.getParameter("textfield2");
		String maintain_smemo=request.getParameter("textarea2");
		maintain mt =new maintain();
				
			mt.setMaintain_thing(maintain_thing);
			mt.setMaintain_homesnumber(maintain_homesnumber);
			mt.setMaintain_fh(maintain_fh);
			mt.setMaintain_smemo(maintain_smemo);
			maintaindao mtdao=new maintaindao(); 
			int result=mtdao.baoxiu(mt);
			if(result>0){
				request.setAttribute("mes", " 报修成功");
				request.getRequestDispatcher("/html/yezhu/topFrameset.jsp").forward(
						request, response);
			}else{
				request.setAttribute("mess", " 报修失败");
				request.getRequestDispatcher("/html/yezhu/topFrameset.jsp").forward(
						request, response);
			}
			
		}
			

}
