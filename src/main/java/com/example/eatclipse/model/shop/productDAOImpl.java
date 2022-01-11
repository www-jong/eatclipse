package com.example.eatclipse.model.shop;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.eatclipse.model.commons.LogDTO;

@Repository
public class productDAOImpl implements productDAO {

	@Inject
	SqlSession sqlSession;

	//메뉴 등록
	@Override
	public void menu_insert(productDTO dto) {
		sqlSession.insert("menu.insert", dto);
	}

	//메뉴 리스트
	@Override
	public List<productDTO> menu_list(String name) {
		return sqlSession.selectList("menu.list",name);
	}

	//메뉴 수정
	@Override
	public void menu_update(productDTO dto) {
		sqlSession.update("menu.update", dto);
	}

	//메뉴 삭제
	@Override
	public void menu_delete(productDTO dto) {
		sqlSession.delete("menu.delete", dto);
	}
	
	//상품 상태 변경 : 0판매
	@Override
	public void typeto0(productDTO dto) {
		sqlSession.update("menu.typeto0",dto);
	}
		
	//상품 상태 변경 : 1품절
	@Override
	public void typeto1(productDTO dto) {
		sqlSession.update("menu.typeto1",dto);
	}

	//주문 목록 리스트
	@Override
	public List<LogDTO> log_list(String userid) {
		return sqlSession.selectList("log.list", userid);
	}

	//주문 상태 변경
	@Override
	public void update_status(LogDTO dto) {
		sqlSession.update("log.status", dto);
	}

	//상품 이름 중복 체크
	@Override
	public String search_product_name(productDTO dto) {
		return sqlSession.selectOne("menu.search", dto);
	}

	//메뉴 1개
	@Override
	public productDTO menu_no(int no) {
		return sqlSession.selectOne("menu.no", no);
	}
	
	@Override
	public void log_nameupdate(Map<String,Object> map) {
		sqlSession.update("menu.log_menuupdate", map);
	}

	@Override
	public List<LogDTO> review_list(String userid) {
		return sqlSession.selectList("log.review",userid);
	}

	
}
