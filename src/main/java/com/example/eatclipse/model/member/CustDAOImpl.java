package com.example.eatclipse.model.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CustDAOImpl implements CustDAO {
	
	@Inject
	SqlSession sqlSession;

	// 로그인 - 나중에 삭제
	@Override
	public String login(CustDTO dto) {
		return sqlSession.selectOne("customer.login", dto);
	}
	
	// 회원가입 등록 - 나중에 삭제
	@Override
	public void insert(CustDTO dto) {
		sqlSession.insert("customer.insert", dto);
	}
	
	// ? - DAO와 함께 파악 예정
	@Override
	public String search_name(CustDTO dto) {
		return sqlSession.selectOne("customer.search_name", dto);
	}
	
	// ? - DAO와 함께 파악 예정
	@Override
	public CustDTO view(String userid) {
		return sqlSession.selectOne("customer.view", userid);
	}
	
	
	// 고객 회원 정보 수정
	@Override
	public void update(CustDTO dto) {
		sqlSession.update("customer.update",dto);
	}
	
	// 고객 계정 삭제
	@Override
	public void delete(String userid) {
		sqlSession.delete("customer.delete",userid);
		
	}

}
