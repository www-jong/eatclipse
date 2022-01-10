package com.example.eatclipse.model.member;

import java.util.List;

import com.example.eatclipse.model.commons.CommonsDTO;

public interface CustDAO {
	
	// 고객 회원 상세 정보 보여주기
	Object view(String userid);
	
	// 캐시 충전
	void cashCharge(CommonsDTO dto);  
	
	// 카테고리 별 식당 목록 확인
	List<CommonsDTO> koreanList(int type);
	List<CommonsDTO> westernList(int type);
	List<CommonsDTO> bunsickList(int type);
	List<CommonsDTO> chineseList(int type);
	List<CommonsDTO> japaneseList(int type);
	List<CommonsDTO> disertList(int type);
	List<CommonsDTO> fastfoodList(int type);
	
	
	
	
	
	
	
	
	
	
	
	
}
