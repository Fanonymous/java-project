package com.gzmu.interManSys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gzmu.interManSys.model.PageBean;
import com.gzmu.interManSys.model.User;
import com.gzmu.interManSys.util.DateUtil;
import com.gzmu.interManSys.util.StringUtil;

public class UserDao {
	// 用户登录，返回值是一个User对象
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

	// 显示用户信息，查询数据
	public ResultSet userList(Connection con, PageBean pageBean, User user) throws Exception {
		StringBuffer sb = new StringBuffer(
				"select * from t_user where level in ('1','2','3') and userName not in('wlzxroot')");
		// 如果姓名不为空，则查询满足该姓名的记录，其他为空
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%'");
		}
		// 如果账号不为空，则查询满足该 账号的记录，其他为空
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isEmpty(user.getName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and userName like '%" + user.getUserName() + "%'");
		}
		// 如果性别不为空，则查询满足该性别的记录，其他为空
		if (StringUtil.isNotEmpty(user.getSex()) && StringUtil.isEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and sex like '%" + user.getSex() + "%'");
		}
		// 如果姓名和账户都不为空的时候，性别为空
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%' and userName like'%" + user.getUserName() + "%'");
		}
		// 如果姓名和性别都不为空，账户为空
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getUserName())) {
			sb.append(" and name like '%" + user.getName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// 如果账户和性别都不为空，姓名为空
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// 如果姓名，账户，性别都不为空
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

	// 统计用户数量
	public int userCount(Connection con, User user) throws Exception {
		StringBuffer sb = new StringBuffer(
				"select count(*) as total from t_user where level in('管理员','职员') and userName not in('wlzxroot')");
		// 如果姓名不为空，则查询满足该姓名的记录，其他为空
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%'");
		}
		// 如果账号不为空，则查询满足该 账号的记录，其他为空
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isEmpty(user.getName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and userName like '%" + user.getUserName() + "%'");
		}
		// 如果性别不为空，则查询满足该性别的记录，其他为空
		if (StringUtil.isNotEmpty(user.getSex()) && StringUtil.isEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and sex like '%" + user.getSex() + "%'");
		}
		// 如果姓名和账户都不为空的时候，性别为空
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getUserName())
				&& StringUtil.isEmpty(user.getSex())) {
			sb.append(" and name like '%" + user.getName() + "%' and userName like'%" + user.getUserName() + "%'");
		}
		// 如果姓名和性别都不为空，账户为空
		if (StringUtil.isNotEmpty(user.getName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getUserName())) {
			sb.append(" and name like '%" + user.getName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// 如果账户和性别都不为空，姓名为空
		if (StringUtil.isNotEmpty(user.getUserName()) && StringUtil.isNotEmpty(user.getSex())
				&& StringUtil.isEmpty(user.getName())) {
			sb.append(" and userName like '%" + user.getUserName() + "%' and sex like '%" + user.getSex() + "%'");
		}
		// 如果姓名，账户，性别都不为空
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

	// 删除用户事件
	public int userDel(Connection con, String delIds) throws Exception {
		String sql = "delete from t_user where id in(" + delIds + ")";
		PreparedStatement ps = con.prepareStatement(sql);
		return ps.executeUpdate();
	}

	// 添加用户事件
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

	// 修改用户事件
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

	// 导出用户信息清单的List
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
