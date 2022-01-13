package com.example.eatclipse.model.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.shop.productDTO;


@Repository
public class CustDAOImpl implements CustDAO {

	@Inject
	SqlSession sqlSession;


	@Override
	public void update(CommonsDTO dto) {
		sqlSession.update("customer.update",dto);

	}

	@Override
	public void delete(String userid) {
		sqlSession.delete("customer.delete", userid);
	}
	
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
	public List<CommonsDTO> shopList(int type){
		return sqlSession.selectList("customer.shopList", type);
	}
	
	// [식당 이름] 눌러서 메뉴 확인. - 식당 이름을 이용해, 등록된 모든 메뉴를 가져오는 작업 : 메뉴 목록
	@Override
	public List<productDTO> menuList(String shop_name) {		
		return sqlSession.selectList("customer.menuList",shop_name);
	}
	
	
	@Override
	public List<LogDTO> userlog(String userid){
		
		return sqlSession.selectList("customer.userlog",userid);
	}

	@Override
	public List<LogDTO> detail(int no) {
		
		return sqlSession.selectList("rider.detail",no);
	}

	@Override
	public void review_set(LogDTO dto) {

		sqlSession.update("customer.review_set", dto);
	}
	
	@Override
	public String review_get(int no) {
		return sqlSession.selectOne("customer.review_get", no);
	}
	
	public List<productDTO> product_no(){
		
		return sqlSession.selectList("customer.product_no");
	}
}
