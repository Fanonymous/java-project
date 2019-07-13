package com.gzmu.interManSys.util;

import java.sql.ResultSet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//导出excel的封装类
public class ExcelUtil {
	
	public static void fillExcelDate(ResultSet rs,Workbook wb,String[] headers) throws Exception{
		int rowIndex = 0;
		Sheet sheet = wb.createSheet();//创建sheet页
		Row row = sheet.createRow(rowIndex++);
		
		//将头的值塞到excel中
		for(int i=0; i<headers.length; i++){
			row.createCell(i).setCellValue(headers[i]);
		}
		//将结果集的值塞到excel中
		while(rs.next()){	//遍历结果集的行
			row = sheet.createRow(rowIndex++);
			for(int i=0; i<headers.length; i++){	//遍历结果集的列
				
				//如果从数据库读出来的结果集为空，是不能直接放到excel的单元格中的，需要将他转化为""字符串，再塞到单元格中
				if(rs.getObject(i+1) == null){
					row.createCell(i).setCellValue("");
				}else{
					row.createCell(i).setCellValue(rs.getObject(i+1).toString());
				}
			}
		}
	}
}
