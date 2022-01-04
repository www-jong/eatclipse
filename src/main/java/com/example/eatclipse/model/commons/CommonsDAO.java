package com.example.eatclipse.model.commons;



public interface CommonsDAO {

	
	//로그인
	String login(CommonsDTO dto);
	
	//회원가입 등록
	void insert(CommonsDTO dto);

	String search_name(CommonsDTO dto);

	Object view(String userid);
	
	//유저정보 업데이트
	void update(CommonsDTO dto);

	//유저탈퇴
	void delete(String userid);
}
