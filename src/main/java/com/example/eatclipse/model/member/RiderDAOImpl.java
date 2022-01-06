package com.example.eatclipse.model.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.eatclipse.model.commons.LogDTO;

@Repository
public class RiderDAOImpl implements RiderDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<LogDTO> delivery_list() {
		
		return sqlSession.selectList("rider.delivery_list");
	}
	
	public List<LogDTO> accept_list(String name) {
		
		return sqlSession.selectList("rider.accept_list",name);
	}


}
