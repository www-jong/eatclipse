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
	public ModelAndView cartinsert(  // 한식식당1, 바나나찌개(no=16)으로 가정. 
			@RequestParam int amount, HttpSession session, ModelAndView mav) {

//		String userid= (String) session.getAttribute("userid");
//		dto.setUserid(userid);
		
		String shop_name = "한식식당1_찌개";  // 일단 한식식당1로 가정.
		int no=16;  // 일단 '바나나찌개' 가정
		
		
		Map<String, Object> map = new HashMap<>();
		String userid=(String)session.getAttribute("userid");
		mav.addObject("userid", userid);
		
		
		List<CartDTO> list = cartDAO.list(userid);
		
		map.put("shop_name", shop_name); // 일단 "한식식당1"로 가정.
		map.put("no", no); // "바나나 찌개".여기서 no는 프로덕트 테이블에서 해당 '메뉴'를 뜻함.
		map.put("userid", session.getAttribute("userid")); // 세션 통해서 로그인된 고객의 id 가져와서 넣기.
		map.put("amount", amount); // 얘는 @RequestParam 통해서 shopInfo.jsp에서 가져온다.
		map.put("product_name", (String) cartDAO.getproductname(no));  
		// no 통해서 프로덕트 테이블에서 해당 메뉴 이름 가져와서 map에 넣기
		int total_price = amount * (cartDAO.getproductprice(no));  // '한 메뉴'에 대한 총 금액
		map.put("total_price", total_price);
		// 이로써 map에 cart table의 모든 컬럼에 대한 요소가 담김.
		
		// map에 다른 정보도 추가.
		int sumMoney=cartDAO.sum_money(userid); //'모든 메뉴'에 대한 금액 합계
		int fee=sumMoney>=30000?0:2500; //배송료
		
		// map에 총금액, 배달비, 최종금액(=총금액+배달비) list, 레코드 갯수도 추가.
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("sum", sumMoney+fee);
		map.put("list", list);
		map.put("count", list.size()); //레코드 개수
		
		
		cartDAO.cartinsert(map);  // 결국 cart(장바구니)에 넣는 것은 이걸 실행시키는 것
		
		mav.addObject("map",map);

		mav.setViewName("cart/cart_list");
		mav.addObject("message", "장바구니에 담겼습니다!"); // 장바구니 담겼다는 alert 뜨게해야됨
		return mav;
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 * 카트 페이지에서 장바구니 목록 나열.
	 * --------------------------------------------------------------------------
	 */
	
	@RequestMapping("cartlist.do") 
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		
		/*
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
		mav.setViewName("cart_list");  */
		
		mav.setViewName("cart/cart_list");
		return mav;
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  메뉴 개별 삭제
	 * --------------------------------------------------------------------------
	 */	
	
	@RequestMapping("delete.do")
	public String delete() {
		
		return "redirect:/cart/list.do";
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  전체 삭제 - 장바구니 비우기
	 * --------------------------------------------------------------------------
	 */
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		
		return "redirect:/cart/list.do";
	}
	
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  메뉴 수정
	 * --------------------------------------------------------------------------
	 */
	
	@RequestMapping("update.do")
	public String update(int[] amount, int[] cart_id, HttpSession session) {
		
		return "redirect:/cart/list.do";
	}
	

}
