package com.example.eatclipse.model.commons;

import java.util.Date;

public class LogDTO {
	private int no;
	private String order_name;
	private String shop_name;
	private String product_name;
	private int amount;
	private String rider_name;
	private String location;
	private int status;
	private Date start_date;
	private Date end_date;
	private String review;
	private int totalmoney;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRider_name() {
		return rider_name;
	}
	public void setRider_name(String rider_name) {
		this.rider_name = rider_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(int totalmoney) {
		this.totalmoney = totalmoney;
	}
	
	public LogDTO(int no, String order_name, String shop_name, String product_name, int amount, String rider_name,
			String location, int status, Date start_date, Date end_date, String review, int totalmoney) {
		this.no = no;
		this.order_name = order_name;
		this.shop_name = shop_name;
		this.product_name = product_name;
		this.amount = amount;
		this.rider_name = rider_name;
		this.location = location;
		this.status = status;
		this.start_date = start_date;
		this.end_date = end_date;
		this.review = review;
		this.totalmoney = totalmoney;
	}
	public LogDTO() {

	}
	@Override
	public String toString() {
		return "LogDTO [no=" + no + ", order_name=" + order_name + ", shop_name=" + shop_name + ", product_name="
				+ product_name + ", amount=" + amount + ", rider_name=" + rider_name + ", location=" + location
				+ ", status=" + status + ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}
	
	
}
