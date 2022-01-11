package com.example.eatclipse.model.shop;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public String getproductname(int no) {
		return sqlSession.selectOne("cart.getproductname", no);
	}

	@Override
	public int getproductprice(int no) {
		return sqlSession.selectOne("cart.getproductprice", no);
	}

	@Override
	public void cartinsert(Map<String, Object> map) {
		sqlSession.insert("cart.cartinsert", map);

	}
	@Override
	public List<CartDTO> list(String product_name){
		return sqlSession.selectList("cart.list", product_name);
		
	}
	
	@Override
	public int sum_money(String userid) {
		return sqlSession.selectOne("cart.sum_money", userid);
	}

}
