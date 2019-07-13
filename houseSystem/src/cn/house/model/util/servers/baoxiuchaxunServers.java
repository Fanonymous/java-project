package cn.house.model.util.servers;

import java.util.List;

import cn.house.vo.maintain;

public interface baoxiuchaxunServers {
	public List<maintain> getUserList(int pageNUmber,int pageSize);
	public int getEmpNumber();

}
