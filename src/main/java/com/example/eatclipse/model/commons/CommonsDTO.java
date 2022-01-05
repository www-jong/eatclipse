package com.example.eatclipse.model.commons;

import java.util.Date;

public class CommonsDTO {
	private int no;
	private int type;
	private String name;
	private String userid;
	private String passwd;
	private String email;
	private int money;
	private String location;
	private Date join_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
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
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	@Override
	public String toString() {
		return "CommonsDTO [no=" + no + ", type=" + type + ", name=" + name + ", userid=" + userid + ", passwd="
				+ passwd + ", email=" + email + ", money=" + money + ", location=" + location + ", join_date="
				+ join_date + "]";
	}
	public CommonsDTO() {

	}
	public CommonsDTO(int no, int type, String name, String userid, String passwd, String email, int money,
			String location, Date join_date) {
		this.no = no;
		this.type = type;
		this.name = name;
		this.userid = userid;
		this.passwd = passwd;
		this.email = email;
		this.money = money;
		this.location = location;
		this.join_date = join_date;
	}
	
	
	
	
}
