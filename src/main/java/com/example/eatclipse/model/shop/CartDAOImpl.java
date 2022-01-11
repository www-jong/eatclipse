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
	public List<CartDTO> cartlist(String userid){
		return sqlSession.selectList("cart.cartlist", userid);
		
	}
	
	@Override
	public int sum_money(String userid) {
		return sqlSession.selectOne("cart.sum_money", userid);
	}
	@Override
	public void Cartinsert(CartDTO dto) {
		sqlSession.insert("cart.cartinsert", dto);

	}
	@Override
	public String anothershopcheck(Map<String,Object> map) {
		return sqlSession.selectOne("cart.anothershopcheck", map);
	}
	@Override
	public int cart_total_price(String userid) {
		return sqlSession.selectOne("cart.cart_total_price",userid);
	}
	@Override
	public void cartdeleteall(String userid) {
		sqlSession.delete("cart.cartdeleteall", userid);
	}
	@Override
	public String cartemptycheck(String userid) {
		
		return sqlSession.selectOne("cart.cartemptycheck", userid);
	}
	
	@Override
	public void cartdelete(Map<String,Object> map) {
		 sqlSession.delete("cart.cartdelete", map);
	}
}
