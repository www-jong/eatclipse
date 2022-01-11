package com.example.eatclipse.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.member.RiderDAO;
import com.example.eatclipse.model.shop.productDTO;

@Controller
@RequestMapping("/rider/*")//라이더 등록수정, 메뉴등록 수정 작업용
public class rideController {

	@Inject
	RiderDAO riderdao;
	
	@RequestMapping("main.do")
	public String maindo() {
		 return "rider/main";
	 }
	
	@RequestMapping("list.do")
	   public ModelAndView list(ModelAndView mav,HttpSession session) {// 현재 배달요청들어온 log와 배달수락한 log들을 다 보여줌
		//log의 status가 2인 목록을  불러오는 dao
		mav.addObject("delivery_list", riderdao.delivery_list());
		//수락한 배달목록을 불러오는 dao
		String name=(String) session.getAttribute("userid");
		System.out.println(name);
		mav.addObject("accept_list", riderdao.accept_list(name));
		mav.setViewName("/rider/list");
	      return mav;
	   }
	
	@RequestMapping("accept/{no}")
	public String acceptdo(@PathVariable("no") int no,HttpSession session) {
		LogDTO dto=new LogDTO();
		dto.setNo(no);
		dto.setRider_name((String) session.getAttribute("userid"));
		 riderdao.accept(dto);
		 return "redirect:/rider/list.do";
	 }
	
	@RequestMapping("complete/{no}")
	public String complete(@PathVariable("no") int no,HttpSession session) {
		// 총금액: sum(product.money*log.amount)+....
		//productDTO dto=new productDTO(); map을 사용해보자
		
		int total=0;
		String shop_id = null;
		List<LogDTO> log_product_list=riderdao.detail(no); // detail을 재활용. 해당no의 log 다들고옴
		for(LogDTO list:log_product_list) { //각각의 주문에 대해 money을 얻어와 amount와 곱해 total을 구하는 과정
			Map<String,Object> map=new HashMap<>(); // 그냥 Map을 써보고싶었어요.
			String s=list.getShop_name(); //log에서 shop의 id들고옴
			shop_id=list.getShop_name(); // 
			String p=list.getProduct_name(); // log에서 제품의 name을 들고옴
			map.put("shop_name", riderdao.getshopname(s));  //id로 shopname을 들고오는과정
			map.put("product_name", p);
			// product테이블에서 배달완료한 음식의 가격을 알아오기위해 log테이블에서 shop_name과 product_name을 들고오고
			// 밑의 getmoney로 price를 조회해옴.  --> log에 money컬럼추가하면되는데 귀찮으니..
			int amount=list.getAmount();
			total+=amount*riderdao.getmoney(map);
		}
		System.out.println(total); // --> 완벽히 작동!
		Map<String,Object> map2=new HashMap<>(); // 그냥 Map을 써보고싶었어요.
		map2.put("userid",session.getAttribute("userid"));
		map2.put("money", total/10);
		System.out.println(total/10);
		riderdao.addmoney(map2);  // 라이더에게 돈 10프로주기
		Map<String,Object> map3=new HashMap<>();
		System.out.println("샵id:"+shop_id);
		map3.put("userid",shop_id); // 여기를 수정해야한다.
		map3.put("money",(total*9)/10);
		riderdao.addmoney(map3); // 가게에게 돈 90프로 주기
		session.setAttribute("money", (int)session.getAttribute("money")+total/10); //세션에 등록하는 과정
		Map<String,Object> map4=new HashMap<>(); // 그냥 Map을 써보고싶었어요.
		map4.put("no",no);
		map4.put("totalmoney", total);
		
		riderdao.complete(map4);
		 return "redirect:/rider/list.do";
	 }
	
	@RequestMapping("detail/{no}")
	public ModelAndView detail(@PathVariable("no") int no,ModelAndView mav,HttpSession session) {
		 mav.setViewName("rider/order_detail");
		 mav.addObject("list",riderdao.detail(no));
		 return mav;
	 }
	
	@RequestMapping("mypage.do")
	public ModelAndView mypage(ModelAndView mav,HttpSession session) {
		mav.setViewName("/rider/mypage");
		mav.addObject("a",2);
		mav.addObject("complete_list",riderdao.complete_list((String) session.getAttribute("userid")));
	
		return mav;
	 }
	@RequestMapping("mypageon.do")
	public ModelAndView mypageon(ModelAndView mav,HttpSession session) {
		mav.setViewName("/rider/mypage");
		mav.addObject("a",1); 
		mav.addObject("complete_list",riderdao.complete_list((String) session.getAttribute("userid")));
		return mav;
	 }
	
	  @RequestMapping("update.do") 
	  public ModelAndView update(@ModelAttribute CommonsDTO dto, HttpSession session,ModelAndView mav) {
	   riderdao.update(dto); //수정처리 
	   //Map<String,Object> map=new HashMap<>(); // 기존name과 바뀐name을 담기위해 생성
	   //riderdao.logtoupdate(map);  // 기존name을 바뀐name으로 바꿔주는 dao
	  session.invalidate(); //세션 초기화
	 	mav.setViewName("commons/login");
	 	mav.addObject("message", "update_success");
	   return mav;
	  }
	  
	 @RequestMapping("delete.do") 
	public ModelAndView delete(@RequestParam String userid, HttpSession session, ModelAndView mav) {
			riderdao.delete(userid);
			session.invalidate(); //세션 초기화
			mav.setViewName("commons/login"); // views/main.jsp
			mav.addObject("message", "delete_success");
			return mav;

	}
	
}
