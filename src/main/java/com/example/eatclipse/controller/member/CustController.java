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
import com.example.eatclipse.model.member.memberDTO;

@Controller
@RequestMapping("/customer/*")   // 고객 로그인 후, 여기로 들어오는 지 확인 필요

public class CustController {
	
	@Inject
	CustDAO custDAO;
	
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

	// 메인에서 [장바구니] 누르면 cart.jsp로 이동
	@RequestMapping("cart.do")
	public String cart() {
		return "customer/cart";
	}	
	
	// 회원이 마이페이지에서 [캐시 충전] 버튼을 누르면 돈 충전.  성공
	@RequestMapping("cashCharge.do")    // 로직 전체 손봐야 해.
	public String cashCharge() {
		return "customer/cashCharge_write";   
	}
	
	@RequestMapping("cashCharge_logic.do")    // 로직 전체 손봐야 해.
	public String cashCharge_logic(@RequestParam int cash,   // cash는 write.jsp의 name.
			HttpSession session) {  // 홍길동의 계정정보 확보. 셋어트리뷰트, 겟어트리뷰트 필요할 때
		
		int money = (int) session.getAttribute("money");
		
		money += cash;
		
		memberDTO dto2 = new memberDTO();   // 텅 비어있는 상태
		dto2.setMoney(money);
		dto2.setUserid((String) session.getAttribute("userid"));
		
		
		custDAO.cashCharge(dto2);
		
		session.setAttribute("money", money);  // 원래 홍길동 돈을 업데이트.
		
		System.out.print("성공");
		
		return "customer/myPage";   
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
	
/////////////   최근 본 가게   /////////////
	
	
	
	
	
	
	
	
	
	
	
}
