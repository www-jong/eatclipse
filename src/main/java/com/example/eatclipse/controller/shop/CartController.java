package com.example.eatclipse.controller.shop;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.example.eatclipse.model.member.RiderDAO;
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
			@ModelAttribute CartDTO dto, HttpSession session,ModelAndView mav) throws UnsupportedEncodingException {
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

		System.out.println("장바구니 테스트용");
		
		String shop_name=(String) dto.getShop_name();
		String name=URLEncoder.encode(shop_name,"utf-8");
		String message=URLEncoder.encode(dto.getProduct_name(),"utf-8");
		//mav.addObject("map",map);
		mav.setViewName("redirect:/customer/shopInfo.do?shop_name="+name+"&message="+message);
		//mav.addObject("message","success");
		}
		else {
			System.out.println("대충 장바구니에 다른가게이름이 들어올려했다는 내용");
			String shop_name=(String) dto.getShop_name();
			String name=URLEncoder.encode(shop_name,"utf-8");
			String message=URLEncoder.encode("error","utf-8");
			  mav.setViewName("redirect:/customer/shopInfo.do?shop_name="+name+"&message="+message);
			 // mav.addObject("message", "error"); // 이건 겹친다는 에러
			 		}
		return mav;
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 * 카트 페이지에서 장바구니 목록 나열.
	 * --------------------------------------------------------------------------
	 */
	
	//수정 by 원종
	@RequestMapping("cartlist.do") 
	public ModelAndView list(HttpServletRequest request,HttpSession session, ModelAndView mav) {
		//자기이름에 해당하는 cartlist를 여기 받아옴(중복다 제거)
		String check="";
		check=cartDAO.cartemptycheck((String) session.getAttribute("userid"));
		if(check!=null) {
			String message=request.getParameter("message");
		mav.addObject("list",cartDAO.cartlist((String) session.getAttribute("userid")));
		// 여기에 담기는 데이터는 product_no, product_name, userid,shop_name, total_amount(그메뉴의모든양),total_price(그메뉴의 모든돈합친거)
		Map<String,Object> map=new HashMap<>(); // 장바구니의 총금액 계산
		map.put("cart_total_price",cartDAO.cart_total_price((String) session.getAttribute("userid")));
		map.put("userid", session.getAttribute("userid"));
		mav.addObject("message",message);
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
	
	@RequestMapping("order.do")
	public ModelAndView order( ModelAndView mav, HttpSession session) throws UnsupportedEncodingException {
		int totalmoney=cartDAO.cart_total_price((String) session.getAttribute("userid"));
		int mymoney=(int) session.getAttribute("money");
		if(totalmoney<=mymoney) {
		mav.addObject("cart_total_price",cartDAO.cart_total_price((String) session.getAttribute("userid")));
		//주문한 목록 보여주기위해 들고옴
		mav.addObject("list",cartDAO.cartlist((String) session.getAttribute("userid")));
		List<CartDTO> orderlist=cartDAO.cartlist((String) session.getAttribute("userid"));
		int no=cartDAO.getmaxno();
		
		for(CartDTO list:orderlist) {
			//no:max(no)+1 , order_name=세션, shop_name=dao로얻어오기,
		LogDTO dto=new LogDTO();
		dto.setNo(no);
		dto.setOrder_name((String) session.getAttribute("userid"));
		dto.setShop_name(cartDAO.getshopid(list.getShop_name()));
		dto.setProduct_name(list.getProduct_name());
		dto.setAmount(list.getAmount());
		dto.setLocation((String) session.getAttribute("location"));
		dto.setStatus(0);
		//dto.setStart_date(now()); 이건 xml에서 처리 
		dto.setTotalmoney(totalmoney);
		System.out.println("로그인서트 확인용");
		cartDAO.loginsert(dto);
		session.setAttribute("money",mymoney-totalmoney);
		Map<String,Object> map=new HashMap<>(); // 장바구니의 총금액 계산
		map.put("money",mymoney-totalmoney);
		map.put("userid", session.getAttribute("userid"));
		cartDAO.moneyupdate(map);
		}
		cartDAO.cartdeleteall((String) session.getAttribute("userid"));
		mav.setViewName("cart/order_complete");
		}
		else {
			String message=URLEncoder.encode("error","utf-8");
			  mav.setViewName("redirect:/cart/cartlist.do?message="+message);
	
		
		}
		return mav;
	}
	
	
	

}
