package com.example.eatclipse.model.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;



@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<CommonsDTO> alllist() {
		
		return sqlSession.selectList("admin.alllist");
	}
	@Override
	public List<CommonsDTO> shoplist(int type) {
		
		return sqlSession.selectList("admin.shoplist",type);
	}
	@Override
	public List<CommonsDTO> riderlist(int type) {
		
		return sqlSession.selectList("admin.riderlist",type);
	}
	@Override
	public List<CommonsDTO> cuslist(int type) {
		
		return sqlSession.selectList("admin.cuslist",type);
	}
	
	@Override
	public void delete(int no) {
		sqlSession.delete("admin.delete", no);
	}

	
	@Override
	public List<LogDTO> loglist() {
		
		return sqlSession.selectList("admin.loglist");
	}
}
