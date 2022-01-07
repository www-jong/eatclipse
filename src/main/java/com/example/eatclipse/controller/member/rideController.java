package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.member.RiderDAO;

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
		String name=(String) session.getAttribute("name");
		System.out.println(name);
		mav.addObject("accept_list", riderdao.accept_list(name));
		mav.setViewName("/rider/list");
	      return mav;
	   }
	
	@RequestMapping("accept/{no}")
	public String acceptdo(@PathVariable("no") int no,HttpSession session) {
		LogDTO dto=new LogDTO();
		dto.setNo(no);
		dto.setRider_name((String) session.getAttribute("name"));
		 riderdao.accept(dto);
		 return "redirect:/rider/list.do";
	 }
	
	@RequestMapping("complete/{no}")
	public String complete(@PathVariable("no") int no,HttpSession session) {
		
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
	public String mypage() {
		 return "rider/mypage";
	 }
	
	
}
