package com.example.eatclipse.model.commons;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonsDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public String login(CommonsDTO dto) {
		return sqlSession.selectOne("commons.login", dto);
	}

	@Override
	public void insert(CommonsDTO dto) {
		sqlSession.insert("commons.insert", dto);

	}

	@Override
	public String search_name(CommonsDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object view(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CommonsDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userid) {
		// TODO Auto-generated method stub

	}

}
