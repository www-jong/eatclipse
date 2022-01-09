package com.example.eatclipse.model.shop;

import java.util.List;

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
	public void menu_delete(int no) {
		sqlSession.delete("menu.delete", no);
	}
	
	//판매 상태 변경
	@Override
	public void menu_type_update(productDTO dto) {
		sqlSession.update("menu.typeupdate", dto);
	}

	@Override
	public List<LogDTO> log_list() {
		return sqlSession.selectList("log.list");
	}

	

	
}
