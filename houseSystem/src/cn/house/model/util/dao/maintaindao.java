package cn.house.model.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cn.house.model.util.DBUtil;

import cn.house.vo.maintain;

public class maintaindao extends DBUtil{
	/****
	 * �û������¼�
	 * @param mt
	 * @return
	 */
	public int baoxiu(maintain mt){
		String sql = "insert into maintain(maintain_thing,maintain_homesnumber,maintain_fh,maintain_smemo)  values(?,?,?,?)";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{mt.getMaintain_thing(),mt.getMaintain_homesnumber(),mt.getMaintain_fh(),mt.getMaintain_smemo()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}
	/****
	 * ��ѯ
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<maintain> querycardbyuc(int start, int limit) {
		String sql = "select * from maintain limit " + start + "," + limit;
		// ����Object����
		Object[] params = new Object[] {};
		// ���ø����еĲ�ѯ����
		List<maintain> emps = super.executeQuery(sql, params, maintain.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}
	/****
	 * ͨ��ά�޹��������Ϣ
	 * @param us
	 * @return
	 */
	public int increas(maintain us) {
		String sql = "insert into  maintain (maintainID) values(?)";
		// �ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[] { us.getMaintainID() };
		// ���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);
	}
	/****
	 * ͨ��ά�ޱ��ɾ��ά����Ϣ
	 * @param maintainID
	 * @return
	 */
	public int delet(int maintainID) {
		String sql = "delete from maintain where maintainID=?";
		Object[] params = new Object[] { maintainID };
		return super.executeUpdate(sql, params);

	}
	/****
	 * ͨ����Ų�ѯά�ޱ���
	 * @param maintainID
	 * @return
	 */
	public List<maintain> querycardbyid(int maintainID) {
		String sql = "select * from maintain where maintainID=?";
		// ����Object����
		Object[] params = new Object[] { maintainID };
		// ���ø����еĲ�ѯ����
		List<maintain> emps = super.executeQuery(sql, params, maintain.class);
		if (emps.size() != 0) {
			return emps;
		} else {
			return null;
		}
	}
	/****
	 * ����ܼ�¼��
	 * @return
	 */
	public int getEmployeeNumber() {
		int count = 0;
		String sql = "select maintainID from  maintain";
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
	 * ͨ��ά�ޱ�ţ��޸�ά��״̬
	 * @param us
	 * @return
	 */
	public int xiugai(maintain car){
		String sql = "update maintain set shifouweixiu=? where maintainID=?";
		//�ṩSQL����У���ռλ����ֵ(ʹ��Object�����ṩ)
		Object[] params = new Object[]{car.getShifouweixiu(),car.getMaintainID()};
		//���ø����е�executeUpdate����ִ��sql���
		return super.executeUpdate(sql, params);

	}


}
