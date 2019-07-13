package cn.house.model.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.house.model.util.DBUtil;
import cn.house.vo.employee;

public class employeedao extends DBUtil {
	/****
	 * ��ѯ������Ϣ
	 * @param ucnoid
	 * @return
	 */
	
	public List<employee> querycardbyuc(int start,int limit){
		String sql = "select * from employee limit "+start+","+limit;
		//����Object����
		Object[] params = new Object[]{};
		//���ø����еĲ�ѯ����
		List<employee> emps = super.executeQuery(sql, params, employee.class);
		if(emps.size()!=0){
			return emps;
		}else{
			return null;
		}
	}
	/****
	 * ���Ա��
	 * @param us
	 * @return
	 */
	public int increas(employee us){
		String sql = "insert into  employee (empDepartment,empWork,empName,id_card,tel,empSex,bornTime,empAcademic,enterTime,workYears,bornLocal,timeLimit) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{us.getEmpDepartment(),us.getEmpWork(),us.getEmpName(),us.getId_card(),us.getTel(),us.getEmpSex(),us.getBornTime(),us.getEmpAcademic(),us.getEnterTime(),us.getWorkYears(),us.getBornLocal(),us.getTimeLimit()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}
	/****
	 * ɾ��Ա��
	 * @param us
	 * @return
	 */
	public int delet(int empId){
		String sql ="delete from employee where empId=?";
		Object[] params =new Object[]{empId};
		return super.executeUpdate(sql, params);
			
	}
	/****
	 * ͨ�����Ų�ѯԱ��
	 * @param empId
	 * @return
	 */
	public List<employee> querycardbyid(int empId){
		String sql = "select * from employee where empId=?";
		//����Object����
		Object[] params = new Object[]{empId};
		//���ø����еĲ�ѯ����
		List<employee> emps = super.executeQuery(sql, params, employee.class);
		if(emps.size()!=0){
			return emps;
		}else{
			return null;
		}
	}
	/****
	 * ����ܼ�¼
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
	 * ����Ա������޸���Ա����Ϣ
	 * @param us
	 * @return
	 */
	public int xiugai(employee us){
		String sql = "update employee set empDepartment=?,empWork=?, empName=? ,id_card=?, tel=? ,empSex=?, bornTime=? ,empAcademic=?, enterTime=? ,workYears=?, bornLocal=? ,timeLimit=? where empId=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{us.getEmpDepartment(),us.getEmpWork(),us.getEmpName(),us.getId_card(),us.getTel(),us.getEmpSex(),us.getBornTime(),us.getEmpAcademic(),us.getEnterTime(),us.getWorkYears(),us.getBornLocal(),us.getTimeLimit(),us.getEmpId()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	
}
}
