package cn.itcase.dao;



import java.util.List;

import cn.itcase.shuju.cards;
import cn.itcase.shuju.users;
import cn.itcase.util.DBUtil;

public class cardsdao extends DBUtil{
	/****
	 * ��ѯ���
	 */
	public cards querycardbyuc(String ucnoid){
		String sql = "select * from cards where ucnoid=?";
		//����Object����
		Object[] params = new Object[]{ucnoid};
		//���ø����еĲ�ѯ����
		List<cards> emps = super.executeQuery(sql, params, cards.class);
		if(emps.size()!=0){
			return emps.get(0);
		}else{
			return null;
		}
	}
	/***
	 * ���
	 * @param car
	 * @return
	 */
	public int cunkuan(cards car){
		String sql = "update cards set yue=? where ucnoid=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{car.getYue(),car.getUcnoid()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}
	/****
	 * ȡ��
	 * @param car
	 * @return
	 */
	public int qukuan(cards car1){
		String sql = "update cards set yue=? where ucnoid=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{car1.getYue(),car1.getUcnoid()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}

}

