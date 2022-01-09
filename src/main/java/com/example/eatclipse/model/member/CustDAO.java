package com.example.eatclipse.model.member;

public interface CustDAO {
	
	// 로그인 : 나중에 삭제
	String login(CustDTO dto);
	
	//회원가입 등록- 나중에 삭제
	void insert(CustDTO dto);
	
	// ? 이건 필요 없을 듯 한데... 나중에 삭제...?
	String search_name(CustDTO dto);
	
	// 고객 회원 상세 정보 보여주기
	Object view(String userid);

	// 고객 회원 정보 수정
	void update(CustDTO dto);
	
	// 고객 계정 삭제
	void delete(String userid);
	
	// 계정확인(비밀번호 확인)
	boolean check_passwd(String userid, String passwd);
	
	// 캐시 충전
	void cashCharge(memberDTO dto);
}
