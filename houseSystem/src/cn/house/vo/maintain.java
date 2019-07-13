package cn.house.vo;

public class maintain {
	private int maintainID;
	private String maintain_thing;
	private String maintain_homesnumber;
	private String maintain_fh;
	private String maintain_smemo;
	private String shifouweixiu;
	public int getMaintainID() {
		return maintainID;
	}
	public void setMaintainID(int maintainID) {
		this.maintainID = maintainID;
	}
	public String getMaintain_thing() {
		return maintain_thing;
	}
	public void setMaintain_thing(String maintain_thing) {
		this.maintain_thing = maintain_thing;
	}
	public String getMaintain_homesnumber() {
		return maintain_homesnumber;
	}
	public void setMaintain_homesnumber(String maintain_homesnumber) {
		this.maintain_homesnumber = maintain_homesnumber;
	}
	public String getMaintain_fh() {
		return maintain_fh;
	}
	public void setMaintain_fh(String maintain_fh) {
		this.maintain_fh = maintain_fh;
	}
	public String getMaintain_smemo() {
		return maintain_smemo;
	}
	public void setMaintain_smemo(String maintain_smemo) {
		this.maintain_smemo = maintain_smemo;
	}
	public String getShifouweixiu() {
		return shifouweixiu;
	}
	public void setShifouweixiu(String shifouweixiu) {
		this.shifouweixiu = shifouweixiu;
	}
	@Override
	public String toString() {
		return "maintain [maintainID=" + maintainID + ", maintain_thing="
				+ maintain_thing + ", maintain_homesnumber="
				+ maintain_homesnumber + ", maintain_fh=" + maintain_fh
				+ ", maintain_smemo=" + maintain_smemo + ", shifouweixiu="
				+ shifouweixiu + "]";
	}
	
	

}
