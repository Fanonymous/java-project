package cn.itcase.shuju;

public class cards {
	private String ucnoid;
	private String yue;
	public void setUcnoid(String ucnoid) {
		this.ucnoid = ucnoid;
	}
	public String getUcnoid() {
		return ucnoid;
	}
	public void setYue(String yue) {
		this.yue = yue;
	}
	public String getYue() {
		return yue;
	}
	public String toString() {
		return "user [ucnoid=" + ucnoid + ", yue=" + yue+ "]";
	}

}
