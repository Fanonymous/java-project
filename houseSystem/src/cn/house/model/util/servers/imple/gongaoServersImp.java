package cn.house.model.util.servers.imple;

import java.util.ArrayList;
import java.util.List;


import cn.house.model.util.dao.gonggaodao;
import cn.house.model.util.servers.gonggaoServers;

import cn.house.vo.gonggao;

public class gongaoServersImp implements gonggaoServers {
	gonggaodao emp=new gonggaodao();
	gonggao emps =new gonggao();
	public List<gonggao> getUserList(int pageNumber,int pageSize) {
		List<gonggao> userVOList = new ArrayList<gonggao>();
		int start = 0;
		if(pageNumber>0){
			start = (pageNumber-1)*pageSize;
		}
		List<gonggao> emps = emp.querycardbyuc(start,pageSize);
		for(gonggao bean :emps){
			gonggao userVO = new gonggao();
			userVO.setGgId(bean.getGgId());
			userVO.setGg(bean.getGg());
			
			userVOList.add(userVO);
		}
		return userVOList;
	}

	
	public int getEmpNumber() {
		return emp.getEmployeeNumber();
	}

}
