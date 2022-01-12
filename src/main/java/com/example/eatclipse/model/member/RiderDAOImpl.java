package com.example.eatclipse.model.member;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.shop.productDTO;

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
	
	@Override
	public void update(CommonsDTO dto) {
		 sqlSession.update("rider.update", dto);

	}

	@Override
	public void delete(String userid) {
		sqlSession.delete("rider.delete",userid);

	}
	@Override
	public int getmoney(Map<String,Object> map) {
		return sqlSession.selectOne("rider.getmoney",map);
	}
	
	@Override
	public void addmoney(Map<String,Object> map) {
		sqlSession.update("rider.addmoney",map);

	}
	
	@Override
	public String getuserid(String name) {
		return sqlSession.selectOne("rider.getuserid",name);

	}
	//상품 상태 변경 : 1품절
	@Override
	public void logtoupdate(Map<String,Object> map) {
		sqlSession.update("rider.logtoupdate",map);
	}
	
	@Override
	public String getshopname(String userid) {
		return sqlSession.selectOne("rider.getshopname",userid);

	}
	
	
	
	@Override
	public List<LogDTO> complete_list(String userid) {
		
		return sqlSession.selectList("rider.complete_list",userid);
	}
	
	@Override
	public LogDTO getlogdata(int no) {
		
		return sqlSession.selectOne("rider.getlogdata",no);
	}
	
	
	
	
	
	
	
	
	
}
