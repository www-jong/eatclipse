package com.example.eatclipse.model.commons;



public interface CommonsDAO {

	
	//로그인
	Integer login(CommonsDTO dto);
	
	//회원가입 등록
	void insert(CommonsDTO dto);

	String search_id(CommonsDTO dto);

	Object view(int no);
	

}
