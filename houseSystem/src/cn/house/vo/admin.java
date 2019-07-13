package cn.house.vo;

public class admin {
	private int adminId;
	private String  admin_name;
	private String  admin_sex;
	private int admin_age;
	private String  admin_tel;
	private String  admin_addr;
	private String  admin_memo;
	private String admin_password;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_sex() {
		return admin_sex;
	}
	public void setAdmin_sex(String admin_sex) {
		this.admin_sex = admin_sex;
	}
	public int getAdmin_age() {
		return admin_age;
	}
	public void setAdmin_age(int admin_age) {
		this.admin_age = admin_age;
	}
	public String getAdmin_tel() {
		return admin_tel;
	}
	public void setAdmin_tel(String admin_tel) {
		this.admin_tel = admin_tel;
	}
	public String getAdmin_addr() {
		return admin_addr;
	}
	public void setAdmin_addr(String admin_addr) {
		this.admin_addr = admin_addr;
	}
	public String getAdmin_memo() {
		return admin_memo;
	}
	public void setAdmin_memo(String admin_memo) {
		this.admin_memo = admin_memo;
	}
	
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	@Override
	public String toString() {
		return "admin [adminId=" + adminId + ", admin_name=" + admin_name
				+ ", admin_sex=" + admin_sex + ", admin_age=" + admin_age
				+ ", admin_tel=" + admin_tel + ", admin_addr=" + admin_addr
				+ ", admin_memo=" + admin_memo + ", admin_password="
				+ admin_password + "]";
	}
	
	
	
	
	
}
