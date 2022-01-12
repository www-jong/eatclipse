package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.commons.CommonsDAO;
import com.example.eatclipse.model.commons.CommonsDTO;



@Controller
@RequestMapping("/commons/*") //로그인/회원가입/로그아웃 관련 작업용
public class CommonsController {
	
	@Inject
	CommonsDAO commonsDao;
	
	@RequestMapping("address.do")
	public String address() {
		return "commons/join";
	}
	
	 @RequestMapping("login.do") //세부적인 url pattern
	public String login(HttpSession session) {
		/*
		 * if(session.getAttribute("type")==null) { return "/commons/login"; } int
		 * type=(int) session.getAttribute("type"); if(type==-1)return
		 * "redirect:/admin.main.do"; else if(type==0)return
		 * "redirect:/commons/main.do"; else if(type==1)return
		 * "redirect:/rider/main.do"; else if(type>=2&&type<=8)return
		 * "redirect:/shop/main.do"; else
		 */ return "/commons/login";
	 
	 }
	 
	 @RequestMapping("login_check.do")
	 public ModelAndView login_check(@ModelAttribute CommonsDTO dto, HttpSession session, ModelAndView mav) {
		 Integer no=commonsDao.login(dto); // Integer는 int랑 다름!! null을 표현할 수 있음!! int는 안됨!! 아오!
		 System.out.println(no);
		 if(no!=null) { //맞으면
			CommonsDTO dto2=(CommonsDTO) commonsDao.view(no); //no를 바탕으로 로그인정보를 다 가져옴
			int type=dto2.getType();
			 System.out.println("로그인 성공, type : "+no); //로그인되는지 확인용으로 넣음.
			 session.setAttribute("type", dto2.getType());
			 session.setAttribute("name", dto2.getName());
			 session.setAttribute("userid", dto.getUserid());
			 session.setAttribute("passwd", dto.getPasswd());
		 	session.setAttribute("email", dto2.getEmail());
		 	session.setAttribute("money", dto2.getMoney());
		 	session.setAttribute("location", dto2.getLocation());
		 	session.setAttribute("join_date", dto2.getJoin_date());
			if(type==0) { //고객이라면 고객페이지로
				 System.out.println("넘어온다");
			
				mav.setViewName("redirect:/customer/main.do"); // views/customer/main.jsp
			 }else if(type==1) { // 라이더페이지로
				 mav.setViewName("redirect:/rider/main.do"); // views/rider/main.jsp
					
			 }else if(type>=2&&type<=8) { //가게들은 가게페이지로
			
				 mav.setViewName("redirect:/shop/main.do"); // views/restaurant/main.jsp
			 }else if(type==-1) { // 관리자라면 관리자페이지로
				 
			
					mav.setViewName("redirect:/admin/main.do"); // views/rider/main.jsp
			 }
			 }else {
			 	mav.setViewName("commons/login");
			 		mav.addObject("message", "error");
		 }
		 return mav;
	 }
	 
	 
	 @RequestMapping("logout.do")
	 public ModelAndView logout(HttpSession session, ModelAndView mav) {
		 session.invalidate(); //세션 초기화
		 mav.setViewName("commons/login");
		 mav.addObject("message", "logout");
		 return mav;
	 }
	 
	 @RequestMapping("join.do")
	 public String join() {
		 return "commons/join_intro";
	 }
	 @RequestMapping("jointo/{n}")
	 public String jointo(@PathVariable("n") int n) {
		 if(n==0) {
			 return "commons/join_cust";
		 }else if(n==1) {
			 return "commons/join_rider";
		 }else if(n==2) {
			 return "commons/join_shop";
		 }else {
			 return "commons/join_cust"; //이상한 접속은 죄다 손님회원가입으로 보내!
		 }
	 }
	 
	 @RequestMapping("join_check.do")
	 public ModelAndView join_check(@ModelAttribute CommonsDTO dto, HttpSession session, ModelAndView mav) {
		 String id=commonsDao.search_id(dto);
		 int t=dto.getType();
		 if(id==null) { //중복되는 이름이 없다면
			 	commonsDao.insert(dto);  // 계정등록
				mav.setViewName("commons/login"); 
				mav.addObject("message", "success");
		 }else {
			 if(t==0) {
				 mav.setViewName("commons/join_cust");
				 mav.addObject("message", "error");
			 }else if(t==1) {
				 mav.setViewName("commons/join_rider");
				 mav.addObject("message", "error");
			 }else if(t>=2&&t<=8) {
				 mav.setViewName("commons/join_shop");
				 String name=commonsDao.search_name(dto);
				 if(name!=null) {
					 mav.addObject("message", "nameerror");
				 }
				 else {
					 mav.addObject("message", "error");
				 }
			 }else {
				 mav.setViewName("commons/join_cust"); //이상한 접속은 죄다 손님회원가입으로 보내!
				 mav.addObject("message", "error");
			 }
			 
		 }
		 return mav;
	 }
	 
	 
		//회원 정보수정하기 --> 각자 구현

	
 }