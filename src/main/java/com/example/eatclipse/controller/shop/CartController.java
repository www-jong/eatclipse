package com.example.eatclipse.controller.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.shop.CartDAO;
import com.example.eatclipse.model.shop.CartDTO;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	
	@Inject
	CartDAO cartDAO;
	
	// 식당 페이지에서 메뉴 장바구니 담기.
	@RequestMapping("cartinsert.do")
	public String cartinsert(  // 한식식당1, 바나나찌개(no=16)으로 가정. 
			@ModelAttribute CartDTO dto, HttpSession session) {
		// 건너오는값: product_no, product_name, amount, price, shop_name
		Map<String,Object> map=new HashMap<>(); // 그냥 Map을 써보고싶었어요.
		map.put("shop_name",dto.getShop_name());
		map.put("userid", session.getAttribute("userid"));
		String check=cartDAO.anothershopcheck(map);
		if(check==null) {
		int total=((int) dto.getTotal_price())*((int) dto.getAmount());
		dto.setTotal_price(total);  // amount와 price를 곱해서 넣어줌.
		                   // 여기 totalprice는 그냥 price로 담아왔기에 이런형태
		dto.setUserid((String) session.getAttribute("userid")); 
		//그럼 여기서 dto는 다 완성됬다.
		
		cartDAO.Cartinsert(dto);
		
		/*
		 * int no=16; // 일단 '바나나찌개' 가정
		 * 
		 * 
		 * Map<String, Object> map = new HashMap<>(); String
		 * userid=(String)session.getAttribute("userid"); mav.addObject("userid",
		 * userid);
		 * 
		 * 
		 * List<CartDTO> list = cartDAO.list(userid);
		 * 
		 * map.put("shop_name", shop_name); // 일단 "한식식당1"로 가정. map.put("no", no); //
		 * "바나나 찌개".여기서 no는 프로덕트 테이블에서 해당 '메뉴'를 뜻함. map.put("userid",
		 * session.getAttribute("userid")); // 세션 통해서 로그인된 고객의 id 가져와서 넣기.
		 * map.put("amount", amount); // 얘는 @RequestParam 통해서 shopInfo.jsp에서 가져온다.
		 * map.put("product_name", (String) cartDAO.getproductname(no)); // no 통해서 프로덕트
		 * 테이블에서 해당 메뉴 이름 가져와서 map에 넣기 int total_price = amount *
		 * (cartDAO.getproductprice(no)); // '한 메뉴'에 대한 총 금액 map.put("total_price",
		 * total_price); // 이로써 map에 cart table의 모든 컬럼에 대한 요소가 담김.
		 * 
		 * // map에 다른 정보도 추가. int sumMoney=cartDAO.sum_money(userid); //'모든 메뉴'에 대한 금액
		 * 합계 int fee=sumMoney>=30000?0:2500; //배송료
		 * 
		 * // map에 총금액, 배달비, 최종금액(=총금액+배달비) list, 레코드 갯수도 추가. map.put("sumMoney",
		 * sumMoney); map.put("fee", fee); map.put("sum", sumMoney+fee); map.put("list",
		 * list); map.put("count", list.size()); //레코드 개수
		 * 
		 * 
		 * cartDAO.cartinsert(map); // 결국 cart(장바구니)에 넣는 것은 이걸 실행시키는 것
		 */		
		System.out.println("장바구니 테스트용");
		
		String go="redirect:/customer/shopInfo/"+dto.getShop_name();
		/*
		 * mav.setViewName("redirect:/customer/shopInfo.do?shop_name="+dto.getShop_name(
		 * )); //이걸 하고싶은데.. mav.addObject("message", "success"); // 장바구니 담겼다는 alert
		 * 뜨게해야됨
		 */		}
		else {
			System.out.println("대충 장바구니에 다른가게이름이 들어올려했다는 내용");
			/*
			 * mav.setViewName("redirect:/customer/shopInfo?shop_name="+dto.getShop_name());
			 * mav.addObject("message", "error"); // 이건 겹친다는 에러
			 */		}
		return "redirect:/customer/shopInfo/"+(String) dto.getShop_name();
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 * 카트 페이지에서 장바구니 목록 나열.
	 * --------------------------------------------------------------------------
	 */
	
	//수정 by 원종
	@RequestMapping("cartlist.do") 
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		//자기이름에 해당하는 cartlist를 여기 받아옴(중복다 제거)
		String check="";
		check=cartDAO.cartemptycheck((String) session.getAttribute("userid"));
		if(check!=null) {
		mav.addObject("list",cartDAO.cartlist((String) session.getAttribute("userid")));
		// 여기에 담기는 데이터는 product_no, product_name, userid,shop_name, total_amount(그메뉴의모든양),total_price(그메뉴의 모든돈합친거)
		Map<String,Object> map=new HashMap<>(); // 장바구니의 총금액 계산
		map.put("cart_total_price",cartDAO.cart_total_price((String) session.getAttribute("userid")));
		map.put("userid", session.getAttribute("userid"));
		
		mav.addObject("map",map);
		mav.setViewName("cart/cart_list");
		}
		else {
			mav.setViewName("cart/cart_empty");
		}
		return mav;
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  메뉴 개별 삭제
	 * --------------------------------------------------------------------------
	 */	
	
	@RequestMapping("delete.do")
	public String delete(HttpServletRequest request,HttpSession session) {
		String product_no=request.getParameter("product_no");  // 얜 왜 int가 안되지
		Map<String,Object> map=new HashMap<>(); 
		map.put("product_no",product_no);
		map.put("userid", session.getAttribute("userid"));
		cartDAO.cartdelete(map);
		return "redirect:/cart/cartlist.do";
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 *  전체 삭제 - 장바구니 비우기
	 * --------------------------------------------------------------------------
	 */
	
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		cartDAO.cartdeleteall((String) session.getAttribute("userid"));
		return "redirect:/cart/cartlist.do";
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
