package com.gzmu.interManSys.util;

import java.sql.ResultSet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//����excel�ķ�װ��
public class ExcelUtil {
	
	public static void fillExcelDate(ResultSet rs,Workbook wb,String[] headers) throws Exception{
		int rowIndex = 0;
		Sheet sheet = wb.createSheet();//����sheetҳ
		Row row = sheet.createRow(rowIndex++);
		
		//��ͷ��ֵ����excel��
		for(int i=0; i<headers.length; i++){
			row.createCell(i).setCellValue(headers[i]);
		}
		//���������ֵ����excel��
		while(rs.next()){	//�������������
			row = sheet.createRow(rowIndex++);
			for(int i=0; i<headers.length; i++){	//�������������
				
				//��������ݿ�������Ľ����Ϊ�գ��ǲ���ֱ�ӷŵ�excel�ĵ�Ԫ���еģ���Ҫ����ת��Ϊ""�ַ�������������Ԫ����
				if(rs.getObject(i+1) == null){
					row.createCell(i).setCellValue("");
				}else{
					row.createCell(i).setCellValue(rs.getObject(i+1).toString());
				}
			}
		}
	}
}
