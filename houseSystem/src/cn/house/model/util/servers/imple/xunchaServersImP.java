package cn.house.model.util.servers.imple;

import java.util.ArrayList;
import java.util.List;


import cn.house.model.util.dao.xunchadao;
import cn.house.model.util.servers.xunchaServers;

import cn.house.vo.xuncha;

public class xunchaServersImP implements xunchaServers {

	xunchadao emp=new xunchadao();
		xuncha emps =new xuncha();
		public List<xuncha> getUserList(int pageNumber,int pageSize) {
			List<xuncha> userVOList = new ArrayList<xuncha>();
			int start = 0;
			if(pageNumber>0){
				start = (pageNumber-1)*pageSize;
			}
			List<xuncha> emps = emp.querycardbyuc(start,pageSize);
			for(xuncha bean :emps){
				xuncha userVO = new xuncha();
				userVO.setXunchaID(bean.getXunchaID());
				userVO.setXuncha_person(bean.getXuncha_person());
				userVO.setXuncha_type(bean.getXuncha_type());
				userVO.setXuncha_time(bean.getXuncha_time());
				userVO.setXuncha_chuliren(bean.getXuncha_chuliren());
				userVO.setXuncha_dangshiren(bean.getXuncha_dangshiren());
				userVO.setXuncha_result(bean.getXuncha_result());
				userVO.setXuncha_memo(bean.getXuncha_memo());
				
				userVOList.add(userVO);
			}
			return userVOList;
		}

	
	public int getEmpNumber() {
		
		return emp.getEmployeeNumber();
	}

}
