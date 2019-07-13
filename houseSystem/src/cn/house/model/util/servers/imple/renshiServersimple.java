package cn.house.model.util.servers.imple;

import java.util.ArrayList;
import java.util.List;

import cn.house.model.util.dao.employeedao;
import cn.house.model.util.servers.renshiServers;
import cn.house.vo.employee;


public class renshiServersimple implements renshiServers{
	
	employeedao emp=new employeedao();
	employee emps =new employee();
	public List<employee> getUserList(int pageNumber,int pageSize) {
		List<employee> userVOList = new ArrayList<employee>();
		int start = 0;
		if(pageNumber>0){
			start = (pageNumber-1)*pageSize;
		}
		List<employee> emps = emp.querycardbyuc(start,pageSize);
		for(employee bean :emps){
			employee userVO = new employee();
			userVO.setEmpId(bean.getEmpId());
			userVO.setEmpDepartment(bean.getEmpDepartment());
			userVO.setEmpWork(bean.getEmpWork());
			userVO.setEmpName(bean.getEmpName());
			userVO.setId_card(bean.getId_card());
			userVO.setTel(bean.getTel());
			userVO.setEmpSex(bean.getEmpSex());
			userVO.setBornTime(bean.getBornTime());
			userVO.setEmpAcademic(bean.getEmpAcademic());
			userVO.setEnterTime(bean.getEnterTime());
			userVO.setWorkYears(bean.getWorkYears());
			userVO.setBornLocal(bean.getBornLocal());
			userVO.setTimeLimit(bean.getTimeLimit());
			userVOList.add(userVO);
		}
		return userVOList;
	}
	@Override
	/****
	 * 添加员工
	 */
	public void addUser(employee userVO) {
		
		
	}
	
	
	@Override
	/****
	 * 通过员工工号 查询员工信息
	 */
	public employee getUserById(int empId) {
		return null;
	}
	@Override
	public int getEmpNumber() {
		return emp.getEmployeeNumber();
	}
	
	

}
