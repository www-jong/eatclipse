package com.example.eatclipse.model.member;

public interface CustDAO {
	
	// 고객 회원 상세 정보 보여주기
	Object view(String userid);
	
	// 캐시 충전
	void cashCharge(memberDTO dto);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
