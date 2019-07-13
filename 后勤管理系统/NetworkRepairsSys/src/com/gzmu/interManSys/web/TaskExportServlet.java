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

import com.gzmu.interManSys.dao.TaskDao;
import com.gzmu.interManSys.util.DbUtil;
import com.gzmu.interManSys.util.ExcelUtil;
import com.gzmu.interManSys.util.ResponseUtil;

public class TaskExportServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	TaskDao taskDao = new TaskDao();
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
			//导出excel的头
			String headers[] = {"报修编号","报修用户姓名","用户报修时间","用户地址","用户联系方式","故障简单描述","维修者","维修时间","完成时间","处理方法简单描述","状态"};
			//得到taskDao.exportTaskList里面的数据
			ResultSet rs = taskDao.exportTaskList(con,null);
			ExcelUtil.fillExcelDate(rs, wb, headers);
			ResponseUtil.exportTask(response, wb, "RepaireList.xls");
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
