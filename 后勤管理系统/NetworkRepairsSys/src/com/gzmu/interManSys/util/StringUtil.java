package com.gzmu.interManSys.util;

public class StringUtil {
	//Ϊ��
	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	//��Ϊ��
	public static boolean isNotEmpty(String str){
		if(!"".equals(str) && str!=null){
			return true;
		}else{
			return false;
		}
	}
}
