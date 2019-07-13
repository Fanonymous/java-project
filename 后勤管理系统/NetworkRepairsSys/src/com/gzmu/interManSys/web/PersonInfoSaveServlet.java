package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.gzmu.interManSys.dao.PersonInfoModifyDao;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DateUtil;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ResponseUtil;
import com.gzmu.interManSys.util.StringUtil;

public class PersonInfoSaveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil=new DbUtil();
	PersonInfoModifyDao psersonInfoModify=new PersonInfoModifyDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�첽������������
		request.setCharacterEncoding("UTF-8");
		//��ǰ̨��ȡ�����޸� ����Ϣ
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String grade=request.getParameter("grade");
		String major=request.getParameter("major");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String id =request.getParameter("id");
		//�жϴ����������Ƿ�Ϊ�գ�Ϊ�վ͸���һ���������ӵ��ַ��������ַ�����ʾ��Ϣû����д����
		if(StringUtil.isEmpty(birthday)){
			birthday="0001-01-01";
		}
		User user=null;
		try {
			user=new User(null,null,null,name,sex,DateUtil.formaString(birthday, "yyyy-MM-dd"),grade,major,phone,address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//���ǰ̨������ID��Ϊ�գ���IDתΪint��������
		if(StringUtil.isNotEmpty(id)){
			user.setUserId(Integer.parseInt(id));
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			int saveNums=0;
			saveNums=psersonInfoModify.personInfoModify(con, user);
			//����޸ĵ��������㣬��Ȼֻ���ܵ�����
			if(saveNums>0){
				result.put("success", "true");
			}
			else{
				result.put("success", "true");
				result.put("errorMsg", "����ʧ��!");
			}
			ResponseUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
