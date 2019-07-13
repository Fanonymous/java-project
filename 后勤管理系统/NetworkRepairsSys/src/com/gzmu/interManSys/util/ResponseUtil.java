package com.gzmu.interManSys.util;

import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

public class ResponseUtil {
	//д����
	public static void write(HttpServletResponse response, Object object) throws Exception{
		response.setContentType("text/html;charset=utf-8");//����ҳ��ı����ʽ
		PrintWriter out=response.getWriter();
		out.println(object.toString());
		out.flush();
		out.close();
	}
	//����excel����
	public static void exportTask(HttpServletResponse response,Workbook wb,String fileName) throws Exception{
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("UTF-8"),"iso8859-1"));
		response.setContentType("application/ynd.ms-excel;charset=UTF-8");
		OutputStream out=response.getOutputStream();
		wb.write(out);
		out.flush();
		out.close();
	}
}
