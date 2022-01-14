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
	public ModelAndView maindo(ModelAndView mav,HttpSession session) {// 현재 배달요청들어온 log와 배달수락한 log들을 다 보여줌
		//log의 status가 2인 목록을  불러오는 dao(배달요청이 들어온 목록)
		mav.addObject("delivery_list", riderdao.delivery_list());

		String name=(String) session.getAttribute("userid");
		//log의 status가 3인 목록을 불러오는 dao(배달수락을 한 목록)
		mav.addObject("accept_list", riderdao.accept_list(name));
		mav.setViewName("/rider/main");
		return mav;
	 }
	
	@RequestMapping("accept/{no}")
	public String acceptdo(@PathVariable("no") int no,HttpSession session) {
		LogDTO dto=new LogDTO();
		// 해당 주문번호를 가져와 수락하는과정(status:1증가시킴)
		dto.setNo(no);
		dto.setRider_name((String) session.getAttribute("userid"));
		 riderdao.accept(dto);
		 return "redirect:/rider/main.do";
	 }
	
	@RequestMapping("complete/{no}")
	public String complete(@PathVariable("no") int no,HttpSession session) {
		//해당로그값을 받아오기 위해 dto 생성, 여러값을 전달하기위해 map 생성
		LogDTO dto=riderdao.getlogdata(no);
		Map<String,Object> map=new HashMap<>();
		//라이더(자기자신)에게 돈을 주는 과정
		map.put("userid",session.getAttribute("userid"));
	map.put("money",dto.getTotalmoney()/10);
	riderdao.addmoney(map); // 라이더에게 10%지급
	session.setAttribute("money",(int) session.getAttribute("money")+(int) dto.getTotalmoney()/10);//세션에도 적용
	//가게에 돈을 주는 과정
		map.put("userid",dto.getShop_name());
		map.put("money",dto.getTotalmoney()*9/10);
		riderdao.addmoney(map);  //가게에게 90% 지급
	  	riderdao.complete(no);
		 return "redirect:/rider/main.do";
	
	 }
	
	@RequestMapping("detail/{no}")
	public ModelAndView detail(@PathVariable("no") int no,ModelAndView mav,HttpSession session) {
		// 해당 주문의 상세정보(주문에 어떤 메뉴들이 들어있나확인)
		 mav.setViewName("rider/order_detail");
		 mav.addObject("list",riderdao.detail(no));
		 return mav;
	 }
	
	@RequestMapping("mypage.do")
	public ModelAndView mypage(ModelAndView mav,HttpSession session) {
		// 마이페이지에 회원정보(수정불가능)이 뜨게
		mav.setViewName("/rider/mypage");
		mav.addObject("a",2);
		mav.addObject("complete_list",riderdao.complete_list((String) session.getAttribute("userid")));
	
		return mav;
	 }
	@RequestMapping("mypageon.do")
	public ModelAndView mypageon(ModelAndView mav,HttpSession session) {
		// 마이페이지에 회원정보(수정가능)이 뜨게
		mav.setViewName("/rider/mypage");
		mav.addObject("a",1); 
		mav.addObject("complete_list",riderdao.complete_list((String) session.getAttribute("userid")));
		return mav;
	 }
	
	  @RequestMapping("update.do") 
	  public ModelAndView update(@ModelAttribute CommonsDTO dto, HttpSession session,ModelAndView mav) {
		  //전달받은 값을 바탕으로 db 업데이트 후, 세션을 초기화하고 로그아웃시킴
	   riderdao.update(dto); //수정처리 
	  session.invalidate(); //세션 초기화
	 	mav.setViewName("commons/login");
	 	mav.addObject("message", "update_success");
	   return mav;
	  }
	  
	 @RequestMapping("delete.do") 
	public ModelAndView delete(@RequestParam String userid, HttpSession session, ModelAndView mav) {
		 //계정삭제
			riderdao.delete(userid);
			session.invalidate(); //세션 초기화
			mav.setViewName("commons/login"); // views/main.jsp
			mav.addObject("message", "delete_success");
			return mav;

	}
	
}
