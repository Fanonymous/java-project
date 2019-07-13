package cn.house.vo;

public class custom_account {
	private int ccustom_accountID;
	private String custom_username;
	private String custom_password;
	
	
	public int getCcustom_accountID() {
		return ccustom_accountID;
	}
	public void setCcustom_accountID(int ccustom_accountID) {
		this.ccustom_accountID = ccustom_accountID;
	}
	public String getCustom_username() {
		return custom_username;
	}
	public void setCustom_username(String custom_username) {
		this.custom_username = custom_username;
	}
	public String getCustom_password() {
		return custom_password;
	}
	public void setCustom_password(String custom_password) {
		this.custom_password = custom_password;
	}
	@Override
	public String toString() {
		return "custom_account [ccustom_accountID=" + ccustom_accountID
				+ ", custom_username=" + custom_username + ", custom_password="
				+ custom_password + "]";
	}
	
	
	
	
	

}
