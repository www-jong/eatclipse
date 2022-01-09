package com.example.eatclipse.model.member;

import java.util.HashMap;
import java.util.Map;

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

	// ? - 나중에 삭제...?
	@Override
	public String search_name(CustDTO dto) {
		return sqlSession.selectOne("customer.search_name", dto);
	}

	// 고객 회원 상세 정보 보여주기
	@Override
	public CustDTO view(String userid) {
		return sqlSession.selectOne("customer.view", userid);
	}

	// 고객 회원 정보 수정
	@Override
	public void update(CustDTO dto) {
		sqlSession.update("customer.update", dto);
	}

	// 고객 계정 삭제
	@Override
	public void delete(String userid) {
		sqlSession.delete("customer.delete", userid);

	}

	// 계정확인(비밀번호 확인)
	@Override
	public boolean check_passwd(String userid, String passwd) {

		boolean result = false;

		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count = sqlSession.selectOne("customer.check_passwd", map);

		if (count == 1) {
			result = true;
		}

		return result;
	}

	
	 // 캐시 충전
	 
	  @Override 
	  public void cashCharge(CustDTO dto) {
		  
			sqlSession.cashCharge("customer.update", dto);
			
	  
	  
	  
	  }
	 

}
