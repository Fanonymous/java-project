package com.community.entity;

public class house {
	private int id;
	private String houseid;
	private int floorid;
	private String shape;
	private String area;
	private String ownername;
	private int people;
	private String ownerphone;
	private String mdate;
	
	
	
	public house(String houseid, int floorid, String shape, String area, String ownername, int people,
			String ownerphone,String mdate) {
		super();
		this.houseid = houseid;
		this.floorid = floorid;
		this.shape = shape;
		this.area = area;
		this.ownername = ownername;
		this.people = people;
		this.ownerphone = ownerphone;
		this.mdate=mdate;
	}
	
	public house(){
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHouseid() {
		return houseid;
	}
	public void setHouseid(String houseid) {
		this.houseid = houseid;
	}
	public int getFloorid() {
		return floorid;
	}
	public void setFloorid(int floorid) {
		this.floorid = floorid;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getOwnerphone() {
		return ownerphone;
	}
	public void setOwnerphone(String ownerphone) {
		this.ownerphone = ownerphone;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	

}
