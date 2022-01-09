package com.example.eatclipse.model.member;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.eatclipse.model.commons.CommonsDTO;

@Repository
public class CustDAOImpl implements CustDAO {

	@Inject
	SqlSession sqlSession;

	// 고객 회원 상세 정보 보여주기
	@Override
	public CommonsDTO view(String userid) {
		return sqlSession.selectOne("customer.view", userid);
	}

	// 캐시 충전

	@Override
	public void cashCharge(memberDTO dto) {

		sqlSession.update("customer.cashCharge", dto);

	}

}
