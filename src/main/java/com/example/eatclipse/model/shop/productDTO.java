package com.example.eatclipse.model.shop;

public class productDTO {
	
	//쿼리의 product에 해당하는 dto
	private String shop_name;
	private String product_name;
	private int price;
	private String image;
	private int type;
	
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public productDTO(String shop_name, String product_name, int price) {
		this.shop_name = shop_name;
		this.product_name = product_name;
		this.price = price;
	}
	public productDTO() {

	}
	@Override
	public String toString() {
		return "productDTO [shop_name=" + shop_name + ", product_name=" + product_name + ", price=" + price + ", image="
				+ image + ", type=" + type + "]";
	}
	
	
	
	
	
	
}
