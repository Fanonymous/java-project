package com.gzmu.interManSys.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {
	//将date日期类型转换成string类型
	public static String formaDate(Date date,String format) throws Exception{
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	} 
	//将String类型转为Date数据类型
public static Date formaString(String str,String format) throws Exception{
		Date result=null;
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(str!=null){
			result=sdf.parse(str);
		}
		return result;
	}
}
