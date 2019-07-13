package com.wuliuSystem.entity;



public class wuliuMessage {
	private String orderID;
	private int adminID;
	private int mid;
	private int sideID;
	private String starttime;
	private String remarks;
	private String goodstatus;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getSideID() {
		return sideID;
	}
	public void setSideID(int sideID) {
		this.sideID = sideID;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getGoodstatus() {
		return goodstatus;
	}
	public void setGoodstatus(String goodstatus) {
		this.goodstatus = goodstatus;
	}
	
	

}
