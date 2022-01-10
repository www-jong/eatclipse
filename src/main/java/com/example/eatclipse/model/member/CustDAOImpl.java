package com.example.eatclipse.model.member;

import java.util.HashMap;
import java.util.List;
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
	public void cashCharge(CommonsDTO dto) {

		sqlSession.update("customer.cashCharge", dto);
	}
	
	
	/* -----------------------------------------------------------------------
	카테고리 별 식당 목록 확인
	고객 main에서 [한식], [양식], [분식] ... 버튼 눌러서 식당 리스트 접근
	--------------------------------------------------------------------------*/
	
	@Override
	public List<CommonsDTO> koreanList(int type){
		return sqlSession.selectList("customer.koreanList", type);
	}
	
	@Override
	public List<CommonsDTO> westernList(int type){
		return sqlSession.selectList("customer.westernList", type);
	}
	
	@Override
	public List<CommonsDTO> bunsickList(int type){
		return sqlSession.selectList("customer.bunsickList", type);
	}
	
	@Override
	public List<CommonsDTO> chineseList(int type){
		return sqlSession.selectList("customer.chineseList", type);
	}
	
	@Override
	public List<CommonsDTO> japaneseList(int type){
		return sqlSession.selectList("customer.japaneseList", type);
	}
	
	@Override
	public List<CommonsDTO> disertList(int type){
		return sqlSession.selectList("customer.disertList", type);
	}
	
	@Override
	public List<CommonsDTO> fastfoodList(int type){
		return sqlSession.selectList("customer.fastfoodList", type);
	}
	
	
	

}
