package cn.itcase.shuju;

public class users {
	private String name;
	private String sex;
	private String cardid;//身份证号
	private String ucnoid;//卡号
    private String password;
	/***
	 * 获得name属性值
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}
	
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUcnoid(String ucnoid) {
		this.ucnoid = ucnoid;
	}
	public String getUcnoid() {
		return ucnoid;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getpassword() {
		return password;
	}
	public String toString() {
		return "user [name=" + name + ", sex=" + sex
				+ ", cardid=" + cardid + ", ucnoid=" + ucnoid + " ,password="+password+"]";
	}
	
	
}
