package com.example.eatclipse.model.shop;

import org.springframework.web.multipart.MultipartFile;

public class productDTO {
	
	//쿼리의 product에 해당하는 dto
	private String shop_name;
	private String product_name;
	private int price;
	private String image;
	private int type;
	private MultipartFile file1;
	
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
	
	
	
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
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
	
	
	public productDTO(String shop_name, String product_name, int price, String image, int type, MultipartFile file1) {
		this.shop_name = shop_name;
		this.product_name = product_name;
		this.price = price;
		this.image = image;
		this.type = type;
		this.file1 = file1;
	}
	public productDTO() {

	}
	@Override
	public String toString() {
		return "productDTO [shop_name=" + shop_name + ", product_name=" + product_name + ", price=" + price + ", image="
				+ image + ", type=" + type + ", file1=" + file1 + "]";
	}

	
	
	
	
	
	
}
