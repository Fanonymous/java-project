package cn.house.model.util.servers;

import java.util.List;

import cn.house.vo.gonggao;

public interface gonggaoServers {
	public List<gonggao> getUserList(int pageNUmber,int pageSize);
	public int getEmpNumber();

}
