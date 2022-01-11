package com.example.eatclipse.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.shop.CartDAO;
import com.example.eatclipse.model.shop.CartDTO;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	
	@Inject
	CartDAO cartDAO;
	
	// 식당 페이지에서 메뉴 장바구니 담기.
	@RequestMapping("cartinsert.do")
	public ModelAndView cartinsert(String shop_name, int no,  // 한식식당1, 바나나찌개(no=16)으로 가정. 
			@RequestParam int amount, HttpSession session, ModelAndView mav) {

//		String userid= (String) session.getAttribute("userid");
//		dto.setUserid(userid);

		Map<String, Object> map = new HashMap<>();
		map.put("shop_name", "한식식당1_찌개"); // 일단 "한식식당1"로 가정.
		map.put("no", 16); // 일단 바나나 찌개 가정  여기서 no는 프로덕트 테이블에서 해당 '메뉴'를 뜻함.
		map.put("userid", session.getAttribute("userid"));
		map.put("amount", amount); // 얘는 @RequestParam 통해서 shopInfo.jsp에서 가져온다.
		map.put("product_name", (String) cartDAO.getproductname(no));
		int total_price = amount * (cartDAO.getproductprice(no));
		map.put("total_price", total_price);
		cartDAO.cartinsert(map);

		mav.setViewName("customer/cart/cart_list");
		mav.addObject("message", "장바구니에 담겼습니다!"); // 장바구니 담겼다는 alert 뜨게해야됨
		return mav;
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 * 카트 페이지에서 장바구니 목록 나열.
	 * --------------------------------------------------------------------------
	 */
	
	@RequestMapping("list.do")  // 여기랑, cart.xml부터...
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		
		Map<String,Object> map=new HashMap<>();
		String userid=(String)session.getAttribute("userid");
		
		String product_name = "바나나 찌개";  // 바나나 찌개 가정
		
		List<CartDTO> list=cartDAO.list(product_name);
		
		int sumMoney=cartDAO.sum_money(userid); //금액 합계
		
		int fee=sumMoney>=30000?0:2500; //배송료
		
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("sum", sumMoney+fee);
		map.put("list", list);
		map.put("count", list.size()); //레코드 개수
		
		
		mav.addObject("map", map);
		mav.setViewName("shop/cart_list");
		
		return mav;
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  메뉴 개별 삭제
	 * --------------------------------------------------------------------------
	 */	
	
	@RequestMapping("delete.do")
	public String delete() {
		
		return "redirect:/customer/cart/list.do";
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  전체 삭제 - 장바구니 비우기
	 * --------------------------------------------------------------------------
	 */
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		
		return "redirect:/customer/cart/list.do";
	}
	
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  메뉴 수정???
	 * --------------------------------------------------------------------------
	 */
	
	@RequestMapping("update.do")
	public String update(int[] amount, int[] cart_id, HttpSession session) {
		
		return "redirect:/customer/cart/list.do";
	}
	

}
