package cn.house.model.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.house.model.util.DBUtil;

import cn.house.vo.gonggao;


public class gonggaodao extends DBUtil {
	/****
	 * ��ѯ����
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<gonggao> querycardbyuc(int start, int limit) {
		String sql = "select * from gonggao limit " + start + "," + limit;
		// ����Object����
		Object[] params = new Object[] {};
		// ���ø����еĲ�ѯ����
		List<gonggao> emps = super.executeQuery(sql, params, gonggao.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}

	/****
	 * ��ӹ���
	 * 
	 * @param us
	 * @return
	 */
	public int increas(gonggao us) {
		String sql = "insert into  gonggao (gG) values(?)";
		// �ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[] { us.getGg() };
		// ���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}

	/****
	 * ɾ������
	 * 
	 * @param ggId
	 * @return
	 */
	public int delet(int ggId) {
		String sql = "delete from gonggao where ggId=?";
		Object[] params = new Object[] { ggId };
		return super.executeUpdate(sql, params);

	}

	/****
	 * ͨ������Ų�ѯ����
	 * 
	 * @param ggId
	 * @return
	 */
	public List<gonggao> querycardbyid(int ggId) {
		String sql = "select * from gonggao where ggId=?";
		// ����Object����
		Object[] params = new Object[] { ggId };
		// ���ø����еĲ�ѯ����
		List<gonggao> emps = super.executeQuery(sql, params, gonggao.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}

	/****
	 * ��ù����ܼ�¼��
	 * 
	 * @return
	 */
	public int getEmployeeNumber() {
		int count = 0;
		String sql = "select ggId from  gonggao";
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
	 * ���ݹ������޸Ĺ���
	 * 
	 * @param us
	 * @return
	 */
	public int xiugai(gonggao car){
		String sql = "update gonggao set gg=? where ggId=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{car.getGg(),car.getGgId()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);

	}
}
