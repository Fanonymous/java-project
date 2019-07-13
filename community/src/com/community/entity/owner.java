package com.community.entity;

public class owner {
	private int id;
	private String owner_name;
	private String owner_sex;
	private String owner_idcard;
	private String owner_phone;
	private String owner_workstation;
	private String houseid;
	private String danyuan;
	private int floorid;
	
	
	
	
	
	
	public owner( String owner_name, String owner_sex, String owner_idcard, String owner_phone,
			String owner_workstation, String houseid, int floorid) {
		super();

		this.owner_name = owner_name;
		this.owner_sex = owner_sex;
		this.owner_idcard = owner_idcard;
		this.owner_phone = owner_phone;
		this.owner_workstation = owner_workstation;
		this.houseid = houseid;
		this.floorid = floorid;
	}
	
	
	public owner(){
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_sex() {
		return owner_sex;
	}
	public void setOwner_sex(String owner_sex) {
		this.owner_sex = owner_sex;
	}
	public String getOwner_idcard() {
		return owner_idcard;
	}
	public void setOwner_idcard(String owner_idcard) {
		this.owner_idcard = owner_idcard;
	}
	public String getOwner_phone() {
		return owner_phone;
	}
	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}
	public String getOwner_workstation() {
		return owner_workstation;
	}
	public void setOwner_workstation(String owner_workstation) {
		this.owner_workstation = owner_workstation;
	}
	public String getHouseid() {
		return houseid;
	}
	public void setHouseid(String houseid) {
		this.houseid = houseid;
	}
	public String getDanyuan() {
		return danyuan;
	}
	public void setDanyuan(String danyuan) {
		this.danyuan = danyuan;
	}
	public int getFloorid() {
		return floorid;
	}
	public void setFloorid(int floorid) {
		this.floorid = floorid;
	}
	
	
		
}
