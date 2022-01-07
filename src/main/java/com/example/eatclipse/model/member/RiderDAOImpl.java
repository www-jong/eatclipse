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
	
	@Override
	public List<LogDTO> accept_list(String name) {
		
		return sqlSession.selectList("rider.accept_list",name);
	}

	//배달수락
	@Override
	public void accept(LogDTO dto) {
		sqlSession.update("rider.accept",dto);
	}
	
	//배달완료
	@Override
	public void complete(int no) {
		sqlSession.update("rider.complete",no);
	}

	@Override
	public List<LogDTO> detail(int no) {
		
		return sqlSession.selectList("rider.detail",no);
	}
}
