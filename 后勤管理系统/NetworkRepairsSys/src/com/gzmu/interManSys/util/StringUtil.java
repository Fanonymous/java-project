package com.gzmu.interManSys.util;

public class StringUtil {
	//Îª¿Õ
	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	//²»Îª¿Õ
	public static boolean isNotEmpty(String str){
		if(!"".equals(str) && str!=null){
			return true;
		}else{
			return false;
		}
	}
}
