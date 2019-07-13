package com.gzmu.interManSys.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {
	//��date��������ת����string����
	public static String formaDate(Date date,String format) throws Exception{
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	} 
	//��String����תΪDate��������
public static Date formaString(String str,String format) throws Exception{
		Date result=null;
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(str!=null){
			result=sdf.parse(str);
		}
		return result;
	}
}
