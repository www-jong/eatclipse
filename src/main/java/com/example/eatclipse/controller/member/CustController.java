package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.member.CustDAO;

@Controller
@RequestMapping("/customer/*")   // 고객 로그인 후, 여기로 들어오는 지 확인 필요

public class CustController {
	
	@Inject
	CustDAO custDAO;

	// 로그 아웃 로직
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		session.invalidate(); // 세션 초기화
		mav.setViewName("commons/login"); // 이거 경로 확인!@#$ commons/ 하면 맞나?
		mav.addObject("message", "logout");
		return mav;
	}

	// 회원의 상세정보를 보여주는 로직
	@RequestMapping("view.do")
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("dto", custDAO.view(userid));
		return "customer/view";    // 이거 경로 확인!@#$
	}
	
	
	
	
	
}
