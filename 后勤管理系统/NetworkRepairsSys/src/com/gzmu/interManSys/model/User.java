package com.gzmu.interManSys.model;
import java.util.Date;
public class User {
	private int userId;               //���
	private String userName;      //�û���,Ҳ�����˺�
	private String password;       //����
	private String level;          //Ȩ��
	private String name;       //�û���������
	private Date birthday;      //��������
	private String sex;       //�Ա�
	private String grade;      //�꼶
	private String major;      //רҵ
	private String phone;       //��ϵ�绰
	private String address;    //ס�޵�ַ
	
	private String myName;		//�������ԣ������洢�û���¼���û���userName

	
	public User() {
		super();
	}
	//�û���¼�Ĺ��췽��
	public User(String userName, String password, String level) {
		super();
		this.userName = userName;
		this.password = password;
		this.level = level;
	}
	//���췽��
	public User(String userName,String password,String level,String name,String sex,Date birthday,String grade,String major,String phone, String address){
		super();
		this.userName=userName;
		this.password=password;
		this.level=level;
		this.name=name;
		this.address=address;
		this.birthday=birthday;
		this.grade=grade;
		this.major=major;
		this.phone=phone;
		this.sex=sex;
	}
	
	public String getUserName() {

		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
