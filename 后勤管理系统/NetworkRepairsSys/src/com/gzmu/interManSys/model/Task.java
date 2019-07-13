package com.gzmu.interManSys.model;

public class Task {
	private int taskId;				//������
	private String userName;		//�û�����
	private String publishTime;		//����ʱ��,����ʱ��
	private String userAddress;		//�û���ַ
	private String phone;			//�û���ϵ�绰
	private String troubelDesc;		//��������
	private String repairer;		//ά����
	
	private String repairTime;		//ά��ʱ��
	private String finishTime;		//���ʱ��
	private String state;			//״̬
	private String dealWay;			//������

	public Task(){
		super();
	}
	//���췽��
	public Task(String userName, String publishTime,
			String userAddress, String phone, String troubelDesc,
			String repairer, String repairTime, String finishTime,  String dealWay,String state) {
		super();
		this.userName = userName;
		this.publishTime = publishTime;
		this.userAddress = userAddress;
		this.phone = phone;
		this.troubelDesc = troubelDesc;
		this.repairer = repairer;
		this.repairTime = repairTime;
		this.finishTime = finishTime;
		this.dealWay = dealWay;
		this.state = state;
		
	}
	//���Ե�getset����
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTroubelDesc() {
		return troubelDesc;
	}
	public void setTroubelDesc(String troubelDesc) {
		this.troubelDesc = troubelDesc;
	}
	public String getRepairer() {
		return repairer;
	}
	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}
	public String getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(String repairtime) {
		this.repairTime = repairtime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDealWay() {
		return dealWay;
	}
	public void setDealWay(String dealWay) {
		this.dealWay = dealWay;
	}
}
