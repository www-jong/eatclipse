package com.example.eatclipse.model.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.eatclipse.model.commons.CommonsDTO;



@Repository
public class AdminDAOImpl implements AdminDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<CommonsDTO> alllist() {
		
		return sqlSession.selectList("admin.alllist");
	}
	@Override
	public List<CommonsDTO> list(int type) {
		
		return sqlSession.selectList("admin.list",type);
	}
	
	@Override
	public void delete(int no) {
		sqlSession.delete("admin.delete", no);
	}

}
