package com.example.eatclipse.model.shop;

public class CartDTO {
	private int product_no;
	private String userid;
	private String product_name;
	private int amount;
	private String shop_name;
	private int total_price;
	
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "CartDTO [product_no=" + product_no + ", userid=" + userid + ", product_name=" + product_name
				+ ", amount=" + amount + ", shop_name=" + shop_name + ", total_price=" + total_price + "]";
	}
	
	

}
