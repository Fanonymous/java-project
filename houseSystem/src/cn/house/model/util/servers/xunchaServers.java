package cn.house.model.util.servers;

import java.util.List;


import cn.house.vo.xuncha;

public interface xunchaServers {
	public List<xuncha> getUserList(int pageNUmber,int pageSize);
	public int getEmpNumber();

}
