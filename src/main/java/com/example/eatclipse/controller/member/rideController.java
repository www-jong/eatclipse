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
		LogDTO dto=riderdao.getlogdata(no);
		Map<String,Object> map=new HashMap<>();
		map.put("userid",session.getAttribute("userid"));
	map.put("money",dto.getTotalmoney()/10);
	riderdao.addmoney(map); // 라이더에게 10%지급
	session.setAttribute("money",(int) session.getAttribute("money")+(int) dto.getTotalmoney()/10);
		map.put("userid",dto.getShop_name());
		map.put("money",dto.getTotalmoney()*9/10);
		riderdao.addmoney(map);  //가게에게 90% 지급
	  	riderdao.complete(no);
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
