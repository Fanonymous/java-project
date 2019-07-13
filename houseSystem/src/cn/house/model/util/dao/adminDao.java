package cn.house.model.util.dao;

import java.util.List;

import cn.house.model.util.DBUtil;
import cn.house.vo.admin;



	public class adminDao extends DBUtil{
		/*****
		 * ����Ա��½
		 */
		public boolean login(int adminId,String admin_password){
			//����SQL���(���У���ռλ���ı�ʾ��ǰSQL����ǲ�������)
			String sql = "select * from admin where adminId=? and admin_password=?";
			//Object�����е�Ԫ�ر�ʾSQL������ʺ�ռλ����ֵ
			Object[] params = new Object[]{adminId,admin_password};
			//���ø����еĲ�ѯ���������е�¼����
			List<admin> us = super.executeQuery(sql, params, admin.class);
			if(us.size() != 0){
				return true;
			}else{
				return false;			
			}
		}
		/****
		 * ����Ա�޸�����
		 * @param cus
		 * @return
		 */
		public int gaimi(admin cus){
			String sql = "update admin set admin_password=? where adminId=?";
			//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
			Object[] params = new Object[]{cus.getAdmin_password(),cus.getAdminId()};
			//���ø����е�executeUpdate����ִ��sql���
			return super.executeUpdate(sql, params);
		}

}
