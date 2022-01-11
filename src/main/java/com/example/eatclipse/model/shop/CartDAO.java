package com.example.eatclipse.model.shop;

import java.util.List;
import java.util.Map;
import com.example.eatclipse.model.shop.CartDTO;


public interface CartDAO {
	
	String getproductname(int no);
	int getproductprice(int no);
	void cartinsert(Map<String,Object> map);
	List<CartDTO> list(String product_name);
	int sum_money(String userid); 

}
