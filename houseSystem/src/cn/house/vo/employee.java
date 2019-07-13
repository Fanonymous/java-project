package cn.house.vo;

public class employee {
	private int empId;
	private String empDepartment;
	private String empWork;
	private String empName;
	private String id_card;
	private String tel;
	private String empSex;
	private String bornTime;
	private String empAcademic;
	private String enterTime;
	private String workYears;
	private String bornLocal;
	private String timeLimit;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpWork() {
		return empWork;
	}
	public void setEmpWork(String empWork) {
		this.empWork = empWork;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getBornTime() {
		return bornTime;
	}
	public void setBornTime(String bornTime) {
		this.bornTime = bornTime;
	}
	public String getEmpAcademic() {
		return empAcademic;
	}
	public void setEmpAcademic(String empAcademic) {
		this.empAcademic = empAcademic;
	}
	public String getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}
	public String getWorkYears() {
		return workYears;
	}
	public void setWorkYears(String workYears) {
		this.workYears = workYears;
	}
	public String getBornLocal() {
		return bornLocal;
	}
	public void setBornLocal(String bornLocal) {
		this.bornLocal = bornLocal;
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
	@Override
	public String toString() {
		return "employee [empId=" + empId + ", empDepartment=" + empDepartment
				+ ", empWork=" + empWork + ", empName=" + empName
				+ ", id_card=" + id_card + ", tel=" + tel + ", empSex="
				+ empSex + ", bornTime=" + bornTime + ", empAcademic="
				+ empAcademic + ", enterTime=" + enterTime + ", workYears="
				+ workYears + ", bornLocal=" + bornLocal + ", timeLimit="
				+ timeLimit + "]";
	}
	
	

}
