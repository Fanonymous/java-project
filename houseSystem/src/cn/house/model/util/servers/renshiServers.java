package cn.house.model.util.servers;

import java.util.List;

import cn.house.vo.employee;

public interface renshiServers {
	//查询员工表
	public List<employee> getUserList(int pageNUmber,int pageSize);
	public void addUser(employee userVO);
	public employee getUserById(int empId);
	public int getEmpNumber();
	

}
