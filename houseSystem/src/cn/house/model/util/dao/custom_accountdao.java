package cn.house.model.util.dao;

import java.util.List;

import cn.house.model.util.DBUtil;
import cn.house.vo.custom_account;

public class custom_accountdao extends DBUtil{
	/****
	 * ҵ����¼����
	 * @param ccustom_accountID
	 * @param custom_password
	 * @return
	 */
	public boolean login(int ccustom_accountID,String custom_password){
		//����SQL���(���У���ռλ���ı�ʾ��ǰSQL����ǲ�������)
		String sql = "select * from custom_account where ccustom_accountID=? and custom_password=?";
		//Object�����е�Ԫ�ر�ʾSQL������ʺ�ռλ����ֵ
		Object[] params = new Object[]{ccustom_accountID,custom_password};
		//���ø����еĲ�ѯ���������е�¼����
		List<custom_account> us = super.executeQuery(sql, params, custom_account.class);
		if(us.size() != 0){
			return true;
		}else{
			return false;			
		}
	}
	/***
	 * ҵ���޸�����
	 * @param cus
	 * @return
	 */
	public int gaimi(custom_account cus){
		String sql = "update custom_account set custom_password=? where ccustom_accountID=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{cus.getCustom_password(),cus.getCcustom_accountID()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}

}
