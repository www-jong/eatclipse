package com.example.eatclipse.model.shop;

import java.util.List;

public interface productDAO {
	
	//가게 등록
	void shop_insert(productDTO dto);
	
	/*
	 * //가게 목록 List<productDTO> shop_list();
	 * 
	 * //가게 수정 void shop_update(productDTO dto);
	 * 
	 * //가게 삭제 void shop_delete(productDTO dto);
	 */
	//가게 상세 
	productDTO shop_detail(int no);
	 
	//메뉴 등록
	void menu_insert(productDTO dto);
		
	//메뉴 목록
	List<productDTO> menu_list();
		
	//메뉴 수정
	void menu_update(productDTO dto);
		
	//메뉴 삭제
	void menu_delete(productDTO dto);
}
