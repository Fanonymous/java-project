package cn.itcase.dao;

import java.util.List;

import cn.itcase.shuju.cards;
import cn.itcase.shuju.users;
import cn.itcase.util.DBUtil;
/***
 * �û��������ݿ����
 * @author Administrator
 *
 */
public class userdao extends DBUtil{

	/***
	 * �û�ע��
	 */
	public int zhuce(users us){
		String sql = "insert into  users values(?,?,?,?,?)";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{us.getUcnoid(),us.getName(),us.getSex(),us.getCardid(),us.getpassword()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
		
	}
	public int zhu(cards us){
		String sqll = "insert into  cards values(?,?)";
		Object[] paramss = new Object[]{us.getUcnoid(),us.getYue()};
		return super.executeUpdate(sqll, paramss);
	}
	/***
	 * �û���¼
	 * @param empNoucnoid
	 * @param password
	 * @return
	 */
	public boolean login(String ucnoid,String password){
		//����SQL���(���У���ռλ���ı�ʾ��ǰSQL����ǲ�������)
		String sql = "select * from users where ucnoid=? and password=?";
		//Object�����е�Ԫ�ر�ʾSQL������ʺ�ռλ����ֵ
		Object[] params = new Object[]{ucnoid,password};
		//���ø����еĲ�ѯ���������е�¼����
		List<users> us = super.executeQuery(sql, params, users.class);
		if(us.size() != 0){
			return true;
		}else{
			return false;			
		}
	}
	/****
	 * �޸�����
	 * @param us
	 * @return
	 */
	public int gaimi(users us){
		String sql = "update users set password=? where ucnoid=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{us.getpassword(),us.getUcnoid()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}
	

}
