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
		 String name=commonsDao.login(dto);
		 if(name!=null) { //맞으면
			 	session.setAttribute("userid", dto.getUserid());
			 	session.setAttribute("username", name);
				mav.setViewName("/main"); // views/main.jsp
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
		 String name=commonsDao.search_name(dto);
		 if(name==null) { //중복되는 이름이 없다면
			 	commonsDao.insert(dto);  // 계정등록
				mav.setViewName("commons/login"); 
				mav.addObject("message", "success");
		 }else {
			 	mav.setViewName("commons/join_write");
			 		mav.addObject("message", "error");
		 }
		 return mav;
	 }
	 
	 
		/*
		 * //회원의 상세정보를 처리하는(보여주는) 로직
		 * 
		 * @RequestMapping("view.do") public String view(@RequestParam String
		 * userid,Model model) { model.addAttribute("dto",memberDao.view(userid));
		 * return "member/view"; }
		 */
		
		//회원 정보수정하기
		/*
		 * @RequestMapping("member/update.do") public ModelAndView
		 * update(@ModelAttribute MemberDTO dto, HttpSession session,ModelAndView mav) {
		 * memberDao.update(dto); //수정처리 session.invalidate(); //세션 초기화
		 * mav.setViewName("member/login"); // views/main.jsp mav.addObject("message",
		 * "update_success"); return mav;
		 * 
		 * }
		 */
		/* @RequestMapping("member/delete.do") */
/*		public ModelAndView delete(@RequestParam String userid, HttpSession session, ModelAndView mav) {
			
				memberDao.delete(userid);
				session.invalidate(); //세션 초기화
				mav.setViewName("member/login"); // views/main.jsp
				mav.addObject("message", "delete_success");
				return mav;

		}*/
 }