package com.gzmu.interManSys.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.gzmu.interManSys.dao.UserDao;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ExcelUtil;
import com.gzmu.interManSys.util.ResponseUtil;

public class UserExportServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			Workbook wb =new HSSFWorkbook();
			//����excel��ͷ
			String headers[] = {"ְԱ���","ְԱ��¼��","����","Ȩ��","����","�Ա�","��������","�꼶","רҵ","��ϵ�绰","��ַ/ס��"};
			//�õ�taskDao.taskList���������
			ResultSet rs = userDao.exportUserList(con, null);
			ExcelUtil.fillExcelDate(rs, wb, headers);
			ResponseUtil.exportTask(response, wb, "UserInfoList.xls");
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
