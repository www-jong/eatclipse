package com.example.eatclipse.model.member;

import java.util.List;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.shop.productDTO;


public interface CustDAO {
	
	void update(CommonsDTO dto);

	void delete(String userid);
	// 고객 회원 상세 정보 보여주기
	Object view(String userid);
	
	// 캐시 충전
	void cashCharge(CommonsDTO dto);  
	
	// 카테고리 별 식당 목록 확인
	List<CommonsDTO> shopList(int type);
	
	// [식당 이름] 눌러서 메뉴 확인. - 식당 이름을 이용해, 등록된 모든 메뉴를 가져오는 작업 : 메뉴 목록
	List<productDTO> menuList(String shop_name);

	
	
	
	
	
	
	
	
	
	
	
	
	
}
