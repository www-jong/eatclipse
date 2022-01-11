package com.example.eatclipse.model.shop;

import java.util.List;
import java.util.Map;
import com.example.eatclipse.model.shop.CartDTO;


public interface CartDAO {
	
	String getproductname(int no);
	int getproductprice(int no);


	List<CartDTO> cartlist(String userid);
	int sum_money(String userid);
	
	void Cartinsert(CartDTO dto);
	String anothershopcheck(Map<String,Object> map);
	
	int cart_total_price(String userid);
	void cartdeleteall(String userid);
	String cartemptycheck(String userid);
	void cartdelete(Map<String, Object> map);
}
