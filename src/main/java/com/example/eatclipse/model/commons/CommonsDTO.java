package com.example.eatclipse.model.commons;

public class CommonsDTO {
	private int type;
	private String name;
	private String userid;
	private String passwd;
	private String email;
	private String location;
	
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public CommonsDTO() {

	}
	public CommonsDTO(int type, String name, String userid, String passwd, String email, String location) {
		this.type = type;
		this.name = name;
		this.userid = userid;
		this.passwd = passwd;
		this.email = email;
		this.location = location;
	}
	@Override
	public String toString() {
		return "CommonsDTO [type=" + type + ", name=" + name + ", userid=" + userid + ", passwd=" + passwd + ", email="
				+ email + ", location=" + location + "]";
	}
	
	
	
}
