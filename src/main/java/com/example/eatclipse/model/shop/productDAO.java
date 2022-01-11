package com.example.eatclipse.model.shop;

import java.util.List;

import com.example.eatclipse.model.commons.LogDTO;

public interface productDAO {

	// 메뉴 등록
	void menu_insert(productDTO dto);

	//메뉴 이름 중복 체크
	String search_product_name(productDTO dto);
	// 메뉴 목록
	List<productDTO> menu_list(String name);

	//메뉴 1개
	String menu_no(int no);
	
	// 메뉴 수정
	void menu_update(productDTO dto);

	// 메뉴 삭제
	void menu_delete(productDTO dto);

	//상품 상태 변경 : 0판매
	void typeto0(productDTO dto);
	
	//상품 상태 변경 : 1판매
	void typeto1(productDTO dto);

	// 주문 목록
	List<LogDTO> log_list(String userid);

	//주문 상태 변경
	void update_status(LogDTO dto);
	
	
}
