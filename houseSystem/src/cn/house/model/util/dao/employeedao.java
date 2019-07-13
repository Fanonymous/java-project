package cn.house.model.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.house.model.util.DBUtil;
import cn.house.vo.employee;

public class employeedao extends DBUtil {
	/****
	 * 查询人事信息
	 * @param ucnoid
	 * @return
	 */
	
	public List<employee> querycardbyuc(int start,int limit){
		String sql = "select * from employee limit "+start+","+limit;
		//创建Object数组
		Object[] params = new Object[]{};
		//调用父类中的查询方法
		List<employee> emps = super.executeQuery(sql, params, employee.class);
		if(emps.size()!=0){
			return emps;
		}else{
			return null;
		}
	}
	/****
	 * 添加员工
	 * @param us
	 * @return
	 */
	public int increas(employee us){
		String sql = "insert into  employee (empDepartment,empWork,empName,id_card,tel,empSex,bornTime,empAcademic,enterTime,workYears,bornLocal,timeLimit) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{us.getEmpDepartment(),us.getEmpWork(),us.getEmpName(),us.getId_card(),us.getTel(),us.getEmpSex(),us.getBornTime(),us.getEmpAcademic(),us.getEnterTime(),us.getWorkYears(),us.getBornLocal(),us.getTimeLimit()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	}
	/****
	 * 删除员工
	 * @param us
	 * @return
	 */
	public int delet(int empId){
		String sql ="delete from employee where empId=?";
		Object[] params =new Object[]{empId};
		return super.executeUpdate(sql, params);
			
	}
	/****
	 * 通过工号查询员工
	 * @param empId
	 * @return
	 */
	public List<employee> querycardbyid(int empId){
		String sql = "select * from employee where empId=?";
		//创建Object数组
		Object[] params = new Object[]{empId};
		//调用父类中的查询方法
		List<employee> emps = super.executeQuery(sql, params, employee.class);
		if(emps.size()!=0){
			return emps;
		}else{
			return null;
		}
	}
	/****
	 * 获得总记录
	 * @return
	 */
	public int getEmployeeNumber(){
		int count = 0;
		String sql = "select empId from  employee";
		ResultSet rs = null;
		try {
			Statement st  = super.getConn().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				rs.getInt(1);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	/****
	 * 根据员工编号修改于员工信息
	 * @param us
	 * @return
	 */
	public int xiugai(employee us){
		String sql = "update employee set empDepartment=?,empWork=?, empName=? ,id_card=?, tel=? ,empSex=?, bornTime=? ,empAcademic=?, enterTime=? ,workYears=?, bornLocal=? ,timeLimit=? where empId=?";
		//提供SQL语句中？号占位符的值(使用Object数组提供)
		Object[] params = new Object[]{us.getEmpDepartment(),us.getEmpWork(),us.getEmpName(),us.getId_card(),us.getTel(),us.getEmpSex(),us.getBornTime(),us.getEmpAcademic(),us.getEnterTime(),us.getWorkYears(),us.getBornLocal(),us.getTimeLimit(),us.getEmpId()};
		//调用父类中的executeUpdate方法执行sql语句
		return super.executeUpdate(sql, params);
	
}
}
