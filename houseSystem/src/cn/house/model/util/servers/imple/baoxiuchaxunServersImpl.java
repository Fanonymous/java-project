package cn.house.model.util.servers.imple;

import java.util.ArrayList;
import java.util.List;


import cn.house.model.util.dao.maintaindao;
import cn.house.model.util.servers.baoxiuchaxunServers;

import cn.house.vo.maintain;

public class baoxiuchaxunServersImpl implements baoxiuchaxunServers {

	maintaindao emp = new maintaindao();
	maintain emps = new maintain();

	public List<maintain> getUserList(int pageNumber, int pageSize) {
		List<maintain> userVOList = new ArrayList<maintain>();
		int start = 0;
		if (pageNumber > 0) {
			start = (pageNumber - 1) * pageSize;
		}
		List<maintain> emps = emp.querycardbyuc(start, pageSize);
		for (maintain bean : emps) {
			maintain userVO = new maintain();
			userVO.setMaintainID(bean.getMaintainID());
			userVO.setMaintain_thing(bean.getMaintain_thing());
			userVO.setMaintain_homesnumber(bean.getMaintain_homesnumber());
			userVO.setMaintain_fh(bean.getMaintain_fh());
			userVO.setMaintain_smemo(bean.getMaintain_smemo());
			userVO.setShifouweixiu(bean.getShifouweixiu());

			userVOList.add(userVO);
		}
		return userVOList;
	}

	public int getEmpNumber() {
		return emp.getEmployeeNumber();
	}

}
