package com.example.eatclipse.model.member;

public class CustDTO {
	
	private int type;
	private String name;
	private String userid;
	private String passwd;
	private String email;
	private int money;
	private String location;
	
	// getter & setter method
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	// toString method
	@Override
	public String toString() {
		return "custDTO [type=" + type + ", name=" + name + ", userid=" + userid + ", passwd=" + passwd + ", email="
				+ email + ", money=" + money + ", location=" + location + "]";
	}
}
