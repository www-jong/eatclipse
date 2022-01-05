package com.example.eatclipse.model.shop;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class productDAOImpl implements productDAO {

	@Inject
	SqlSession sqlSession;

	//가게 등록
	@Override
	public void shop_insert(productDTO dto) {
		sqlSession.insert("shop.insert", dto);
	}
	
	//가게 상세보기
	@Override
	public productDTO shop_detail(int no) {
		return sqlSession.selectOne("shop.detail", no) ;
	}

	//메뉴 등록
	@Override
	public void menu_insert(productDTO dto) {
		sqlSession.insert("shop.menuinsert", dto);
	}

	//메뉴 리스트
	@Override
	public List<productDTO> menu_list() {
		return sqlSession.selectList("shop.menulist");
	}

	//메뉴 수정
	@Override
	public void menu_update(productDTO dto) {
		sqlSession.update("shop.menuupdate", dto);
	}

	//메뉴 삭제
	@Override
	public void menu_delete(productDTO dto) {
		sqlSession.delete("shop.menudelete", dto);
	}

}
