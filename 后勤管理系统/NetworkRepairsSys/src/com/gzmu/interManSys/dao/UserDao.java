package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DateUtil;
import com.gzmu.interManSys.util.StringUtil;

public class UserDao {
	// �û���¼������ֵ��һ��User����
	public User login(Connection con, User user) throws Exception {
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=? and level=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());
		stmt.setString(3, user.getLevel());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			resultUser = new User();
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setLevel(rs.getString("level"));
		}
		return resultUser;
	}

	// ��ʾ�û���Ϣ����ѯ����
	public ResultSet userList(Connection con, PageBean pageBean, User user) throws Exception {
		StringBuffer sb = new StringBuffer(
				"select * from t_user where level in ('1','2','3') and userName not in('wlzxroot')");
		// ���������Ϊ�գ����ѯ����������ļ�¼������Ϊ��
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%'");
		}
		// ����˺Ų�Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isEmpty(user.getName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and userName like '%" + user.getUserName() + "%'");
		}
		// ����Ա�Ϊ�գ����ѯ������Ա�ļ�¼������Ϊ��
		if (StringUtil.isNotEmpty(user.getSex()) && StringUtil.isEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and sex like '%" + user.getSex() + "%'");
		}
		// ����������˻�����Ϊ�յ�ʱ���Ա�Ϊ��
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%' and userName like'%" + user.getUserName() + "%'");
		}
		// ����������Ա𶼲�Ϊ�գ��˻�Ϊ��
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getUserName())) {
			sb.append(" and name like '%" + user.getName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// ����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// ����������˻����Ա𶼲�Ϊ��
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isNotEmpty(user.getName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%' and sex like '%" + user.getSex()
					+ "%' and name like '%" + user.getName() + "%'");
		}
		if (pageBean != null) {
			sb.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	// ͳ���û�����
	public int userCount(Connection con, User user) throws Exception {
		StringBuffer sb = new StringBuffer(
				"select count(*) as total from t_user where level in('����Ա','ְԱ') and userName not in('wlzxroot')");
		// ���������Ϊ�գ����ѯ����������ļ�¼������Ϊ��
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%'");
		}
		// ����˺Ų�Ϊ�գ����ѯ����� �˺ŵļ�¼������Ϊ��
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isEmpty(user.getName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and userName like '%" + user.getUserName() + "%'");
		}
		// ����Ա�Ϊ�գ����ѯ������Ա�ļ�¼������Ϊ��
		if (StringUtil.isNotEmpty(user.getSex()) && StringUtil.isEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and sex like '%" + user.getSex() + "%'");
		}
		// ����������˻�����Ϊ�յ�ʱ���Ա�Ϊ��
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%' and userName like'%" + user.getUserName() + "%'");
		}
		// ����������Ա𶼲�Ϊ�գ��˻�Ϊ��
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getUserName())) {
			sb.append(" and name like '%" + user.getName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// ����˻����Ա𶼲�Ϊ�գ�����Ϊ��
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// ����������˻����Ա𶼲�Ϊ��
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isNotEmpty(user.getName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%' and sex like '%" + user.getSex()
					+ "%' and name like '%" + user.getName() + "%'");
		}
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}

	// ɾ���û��¼�
	public int userDel(Connection con, String delIds) throws Exception {
		String sql = "delete from t_user where id in(" + delIds + ")";
		PreparedStatement ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	// ����û��¼�
	public int userAdd(Connection con, User user) throws Exception {
		String sql = "insert into t_user value(null,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getLevel());
		ps.setString(4, user.getName());
		ps.setString(5, user.getSex());
		ps.setString(6, DateUtil.formaDate(user.getBirthday(), "yyyy-MM-dd"));
		ps.setString(7, user.getGrade());
		ps.setString(8, user.getMajor());
		ps.setString(9, user.getPhone());
		ps.setString(10, user.getAddress());
		return ps.executeUpdate();
	}

	// �޸��û��¼�
	public int userUpdate(Connection con, User user) throws Exception {
		String sql = "update t_user set userName=?, password=?, level=?, name=?, sex=?, birthday=?, grade=?, major=?, phone=?, address=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getLevel());
		ps.setString(4, user.getName());
		ps.setString(5, user.getSex());
		ps.setString(6, DateUtil.formaDate(user.getBirthday(), "yyyy-MM-dd"));
		ps.setString(7, user.getGrade());
		ps.setString(8, user.getMajor());
		ps.setString(9, user.getPhone());
		ps.setString(10, user.getAddress());
		ps.setInt(11, user.getUserId());
		return ps.executeUpdate();
	}

	// �����û���Ϣ�嵥��List
	public ResultSet exportUserList(Connection con, PageBean pageBean) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_user");
		if (pageBean != null) {
			sb.append(" limit ?,?");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		if (pageBean != null) {
			pstmt.setInt(1, pageBean.getStart());
			pstmt.setInt(2, pageBean.getRows());
		}
		return pstmt.executeQuery();
	}
}
