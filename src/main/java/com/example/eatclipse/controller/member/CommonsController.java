package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String login() {
		 return "commons/login";
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
			
				mav.setViewName("/customer/main"); // views/customer/main.jsp
			 }else if(type==1) { // 라이더페이지로
				 mav.setViewName("/rider/main"); // views/rider/main.jsp
					
			 }else if(type>=2&&type<=8) { //가게들은 가게페이지로
			
				 mav.setViewName("/shop/main"); // views/restaurant/main.jsp
			 }else if(type==-1) { // 관리자라면 관리자페이지로
				 
			
					mav.setViewName("/admin/main"); // views/rider/main.jsp
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
		 return "commons/join_write";
	 }
	 
	 @RequestMapping("join_check.do")
	 public ModelAndView join_check(@ModelAttribute CommonsDTO dto, HttpSession session, ModelAndView mav) {
		 String id=commonsDao.search_id(dto);
		 if(id==null) { //중복되는 이름이 없다면
			 	commonsDao.insert(dto);  // 계정등록
				mav.setViewName("commons/login"); 
				mav.addObject("message", "success");
		 }else {
			 	mav.setViewName("commons/join_write");
			 		mav.addObject("message", "error");
		 }
		 return mav;
	 }
	 
	 
		//회원 정보수정하기 --> 각자 구현

	
 }