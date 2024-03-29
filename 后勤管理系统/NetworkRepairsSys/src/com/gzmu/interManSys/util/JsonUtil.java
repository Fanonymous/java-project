package com.gzmu.interManSys.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	public static JSONArray formatRsToJsonArray(ResultSet rs)throws Exception{
		ResultSetMetaData md=rs.getMetaData();
		int num=md.getColumnCount();//
		JSONArray array =new JSONArray();
		//横向遍历
		while(rs.next()){
			JSONObject mapOfColValues=new JSONObject();
			//纵向遍历
			for(int i=1;i<=num;i++){
				Object o=rs.getObject(i);
				//判断转来的类型是否为date类型
				if(o instanceof Date){
					mapOfColValues.put(md.getColumnName(i), DateUtil.formaDate((Date)o , "yyyy-MM-dd"));
				}else{
					mapOfColValues.put(md.getColumnName(i),rs.getObject(i));
				}
			}
			array.add(mapOfColValues);
		}
		return array;
	}
}
