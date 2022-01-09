package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.member.CustDAO;
import com.example.eatclipse.model.member.CustDTO;

@Controller
@RequestMapping("/customer/*")   // 고객 로그인 후, 여기로 들어오는 지 확인 필요

public class CustController {
	
	@Inject
	CustDAO custDAO;

	// 로그 아웃 로직_이거 없애도 될듯
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		session.invalidate(); // 세션 초기화
		mav.setViewName("commons/login"); // 이거 경로 확인!@#$ commons/ 하면 맞나?
		mav.addObject("message", "logout");
		return mav;
	}
	
	// home 버튼 누르면 메인페이지로
	@RequestMapping("main.do")
		public String main() {
			return "customer/main";
	}
	
	
	// 회원이 main에서 [마이페이지] 버튼 누르면, myPage.jsp로 이동하여 상세정보 보여주는 로직
	// 파람 ver
	@RequestMapping("myPage.do")
	public String myPage(@RequestParam String userid, Model model) {
		model.addAttribute("dto", custDAO.view(userid));
		return "customer/myPage";
	}  
	
	
	/*
	// 회원이 main에서 [마이페이지] 버튼 누르면, myPage.jsp로 이동하여 상세정보 보여주는 로직
	// 세션 ver   # 이거 잘 안됨
	@RequestMapping("myPage.do")
	public String myPage(HttpSession session, Model model) {
		String userid=(String)session.getAttribute("userid");
//		model.addAttribute("dto", custDAO.view(userid));
		return "customer/myPage";
	} */

	
	
	// 메인에서 [장바구니] 누르면 cart.jsp로 이동
	@RequestMapping("cart.do")
	public String cart() {
		return "customer/cart";
	}
	
	/* 이거 필요 없을 듯
	// 회원이 main에서 [마이페이지] 버튼 누르면, view.jsp에서 상세정보 보여주는 로직
	@RequestMapping("view.do")   // 이거 경로 확인!@#$!@#$%^&*()
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("dto", custDAO.view(userid));
		return "customer/view";    // 이거 경로 확인!@#$
	}  */
	
	
	/*  실패.
	// myPage.jps에서 [수정] 버튼 눌러 회원 정보수정하기 # 아마도?
	@RequestMapping("customer/update.do")   // 이거 경로 확인!@#$
	public ModelAndView update(@ModelAttribute CustDTO dto, 
			HttpSession session, ModelAndView mav) {
		custDAO.update(dto); // 수정처리
		session.invalidate(); // 세션 초기화
		mav.setViewName("/eclipse/commons/login"); // 이거 경로 확인!@#$
		mav.addObject("message", "정보 수정이 완료되었습니다!");
		return mav;
	}  */

	/* 실패
	// myPage.jps에서 [삭제] 버튼 눌러 탈퇴
	@RequestMapping("customer/delete.do")
	public ModelAndView delete(@RequestParam String userid, 
			HttpSession session, ModelAndView mav) {

		custDAO.delete(userid);
		session.invalidate(); // 세션 초기화
		mav.setViewName("/eclipse/commons/login"); // 이거 경로 확인!@#$!@#$%^&*()
		mav.addObject("message", "칫, 탈퇴 됐당. 배고프면 언제든지 컴백!");
		return mav;
	}		*/
	
	@RequestMapping("update.do")   // 실패
	public ModelAndView update(@ModelAttribute CustDTO dto, 
			Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		boolean result = custDAO.check_passwd(dto.getUserid(), dto.getPasswd());
		if(result) {
							
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", dto.getName());
			
			custDAO.update(dto);
			mav.setViewName("/eatclipse/customer/myPage");
			
			return mav;
							
		}else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			mav.setViewName("/eatclipse/customer/myPage");
			mav.addObject("message", "비밀번호가 일치하지 않습니다.");
			return mav;
		}
	}	
	
	// 회원이 마이페이지에서 [캐시 충전] 버튼을 누르면 돈 충전.
	@RequestMapping("cashCharge.do")    // 로직 전체 손봐야 해.
	public String cashCharge(@ModelAttribute CustDTO dto) {
		
//		custDAO.cashCharge(String userid, int amount);
		
		return "customer/cashCharge";   
	}
	
	/////////////   고객 main에서 [한식], [양식], [분식] ... 버튼 눌러서 식당 리스트 접근   ///////////
	
	@RequestMapping("korean.do")
	public String korean() {
		
		// 내용 작성해야 해. 그런데 잘 모르겠음...ㅜㅠ
		
		return "customer/korean";
	}
	
	@RequestMapping("western.do")
	public String western() {
		
		// 내용 작성 필요. 한식만 성공하면 여기는 껌.
		
		return "customer/western";
	}
	
	@RequestMapping("bunsick.do")
	public String bunsick() {
		
		// 내용 작성 필요. 한식만 성공하면 여기는 껌.
		
		return "customer/bunsick";
	}
	
/////////////   최근 본 가게   ///////////
	
	
	
	
	
	
	
	
	
	
	
}
