package cn.house.model.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.house.model.util.DBUtil;

import cn.house.vo.xuncha;

public class xunchadao extends DBUtil{
	/****
	 * ��ѯѲ����Ϣ
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<xuncha> querycardbyuc(int start, int limit) {
		String sql = "select * from xuncha limit " + start + "," + limit;
		// ����Object����
		Object[] params = new Object[] {};
		// ���ø����еĲ�ѯ����
		List<xuncha> emps = super.executeQuery(sql, params, xuncha.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}

	/****
	 * ���Ѳ��
	 * 
	 * @param us
	 * @return
	 */
	public int increas(xuncha us) {
		String sql = "insert into  xuncha (xuncha_person,xuncha_type,xuncha_time,xuncha_chuliren,xuncha_dangshiren,xuncha_result,xuncha_memo) values(?,?,?,?,?,?,?)";
		// �ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[] { us.getXuncha_person(),us.getXuncha_type(),us.getXuncha_time(),us.getXuncha_chuliren(),us.getXuncha_dangshiren(),us.getXuncha_result(),us.getXuncha_memo() };
		// ���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}

	/****
	 * ɾ��Ѳ����Ϣ
	 * @param xunchaID
	 * @return
	 */
	public int delet(int xunchaID) {
		String sql = "delete from xuncha where xunchaID=?";
		Object[] params = new Object[] { xunchaID };
		return super.executeUpdate(sql, params);

	}

	/****
	 * ����Ѳ���Ų�ѯѲ����Ϣ
	 * @param xunchaID
	 * @return
	 */
	public List<xuncha> querycardbyid(int xunchaID) {
		String sql = "select * from xuncha where xunchaID=?";
		// ����Object����
		Object[] params = new Object[] { xunchaID };
		// ���ø����еĲ�ѯ����
		List<xuncha> emps = super.executeQuery(sql, params, xuncha.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}

	/***
	 * ����ܼ�¼��
	 * @return
	 */
	public int getEmployeeNumber() {
		int count = 0;
		String sql = "select xunchaID from  xuncha";
		ResultSet rs = null;
		try {
			Statement st = super.getConn().createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
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
	 * ����Ѳ�����޸�Ѳ����Ϣ
	 * @param car
	 * @return
	 */
	public int xiugai(xuncha car){
		String sql = "update xuncha set xuncha_person=?,xuncha_type=?,xuncha_time=?,xuncha_chuliren=?,xuncha_dangshiren=?,xuncha_result=?,xuncha_memo=? where xunchaID=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{car.getXuncha_person(),car.getXuncha_type(),car.getXuncha_time(),car.getXuncha_chuliren(),car.getXuncha_dangshiren(),car.getXuncha_result(),car.getXuncha_memo(),car.getXunchaID()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);

	}

}
