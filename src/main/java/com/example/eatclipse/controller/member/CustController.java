package com.example.eatclipse.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.member.CustDAO;
import com.example.eatclipse.model.member.CustDTO;
import com.example.eatclipse.model.member.memberDTO;
import com.example.eatclipse.model.shop.productDTO;


@Controller
@RequestMapping("/customer/*") // 고객 로그인 후, 여기로 들어오는 지 확인 필요 : 종현씨 수정 완료.

public class CustController {

	@Inject
	CustDAO custDAO;

	/*-----------------------------------------------------------------
	어디서나 상단 Home 버튼 누르면 메인페이지로 이동
	------------------------------------------------------------------*/

	@RequestMapping("main.do")
	public String main() {
		return "customer/main";
	}

	/*-----------------------------------------------------------------
	회원이 main에서 [마이페이지] 버튼 누르면, 
	myPage.jsp로 이동하여 상세회원정보 보여주는 로직
	
	   * 이슈 : 충전 후, 다시 마이페이지 들어올 때 회원정보가 나타나지 않음!
	   * 과거 주문 내역 쭉 나오는 기능도 여기서 만들어야 하나?
	------------------------------------------------------------------*/

	@RequestMapping("myPage.do")
	public String myPage(@RequestParam String userid, Model model) {
		model.addAttribute("dto", custDAO.view(userid));
		return "customer/myPage";
	}
	
	/*-----------------------------------------------------------------
	회원이 마이페이지에서 회원 정보 수정
	------------------------------------------------------------------*/
	@RequestMapping("update.do")
	public ModelAndView update(@ModelAttribute CommonsDTO dto,
			HttpSession session, ModelAndView mav) {
		
		custDAO.update(dto);
		session.invalidate();
		mav.setViewName("commons/login.do");
		mav.addObject("message", "회원 정보 수정 성공");
		return mav;
	}
	
	@RequestMapping("member/delete.do")
	public ModelAndView delete(@RequestParam String userid, HttpSession session, ModelAndView mav) {
		
			custDAO.delete(userid);
			session.invalidate(); //세션 초기화
			mav.setViewName("commons/login.do"); 
			mav.addObject("message", "탈퇴 성공. 배고프면 다시 와~");
			return mav;

	}
	
	
	

	/*-----------------------------------------------------------------
	회원이 마이페이지에서 [캐시 충전] 버튼을 누르면 돈 충전.  기본은 성공
	
	   * 이슈 : 충전 후, 다시 마이페이지 들어올 때 회원정보가 나타나지 않음!
	------------------------------------------------------------------*/

	@RequestMapping("cashCharge.do")
	public String cashCharge() {
		return "customer/cashCharge_write";
	}

	@RequestMapping("cashCharge_logic.do") // 로직 전체 손봐야 해.
	public String cashCharge_logic(@RequestParam int cash, // cash는 write.jsp의 name.
			HttpSession session) {
		// HttpSession session : 홍길동의 계정정보 확보. 셋어트리뷰트, 겟어트리뷰트 필요할 때

		int money = (int) session.getAttribute("money");

		money += cash;

		CommonsDTO dto2 = new CommonsDTO(); // 텅 비어있는 상태
		dto2.setMoney(money);
		dto2.setUserid((String) session.getAttribute("userid"));

		custDAO.cashCharge(dto2);

		session.setAttribute("money", money); // 원래 홍길동 돈을 업데이트.

		System.out.print("성공");

		return "customer/myPage";
	}

	/*
	 * ----------------------------------------------------------------------- 
	 * 고객 main에서 [한식], [양식], [분식] ... 버튼 눌러서 카테고리별 식당 리스트 확인 및 접근
	 * 1/10(월) 오전 일부 완성 - 
	 * --------------------------------------------------------------------------
	 */

	@RequestMapping("shopList/{type}")
	public ModelAndView list(@PathVariable("type") int type, ModelAndView mav) {

		mav.setViewName("/customer/shop_list");
		mav.addObject("list", custDAO.shopList(type));
		mav.addObject("t", type);

		return mav;
	}
	
	/*
	 * ----------------------------------------------------------------------- 
	 * 식당 이름을 선택 시 각 식당의 메뉴 볼 수 확인 및 장바구니.
	 *   * 망.... 확장 실패.
	 * --------------------------------------------------------------------------
	 */

	@RequestMapping("shopInfo.do")     
	// PathVariable 쓰려면 {shop_name}으로 해야함.
	// 그런데 문제는 각 카테고리마다 식당 수도 다르고, 유동적으로 변해야 함.
	// 어케 해?ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	// --> httpservletrequest 사용.
	public ModelAndView menuList(HttpServletRequest request,
			 HttpSession session, ModelAndView mav) {
		String shop_name="";
		shop_name=request.getParameter("shop_name"); //샵네임이 전달될경우
		//가게이름으로 그 가게의 음식목록 불러오기(근데 품절이면 선택불가(.jsp에서구현)
		mav.addObject("productList",custDAO.menuList(shop_name));
		mav.addObject("shop_name", shop_name); //가게이름만 따로 전달
		mav.setViewName("/customer/shopInfo");
		return mav;
	}

	/*
	 * -----------------------------------------------------------------------
	 * 장바구니 - 주요 기능은 CartController
	 * --------------------------------------------------------------------------
	 */

	// 메인에서 [장바구니] 누르면 cart.jsp로 이동
	@RequestMapping("cart.do")
	public String cart() {
		return "customer/cart_list";  // 경로!
	}

	/*
	 * ----------------------------------------------------------------------- 
	 * <마이페이지> 누르면 주문 내역 쭉 나오기
	 * --------------------------------------------------------------------------
	 */
	
	
	/*
	 * ----------------------------------------------------------------------- 
	 * <최근 본 가게>
	 * --------------------------------------------------------------------------
	 */

	
	
	
	
	/*
	 * ----------------------------------------------------------------------- 
	 * <주문> - 카트 컨트로러에서
	 * --------------------------------------------------------------------------
	 */

	
	
	
	
	/*
	 * ----------------------------------------------------------------------- 
	 * <리뷰>
	 * --------------------------------------------------------------------------
	 */
	
	
	
	/*
	 * ----------------------------------------------------------------------- 
	 * <검색 기능>
	 * --------------------------------------------------------------------------
	 */
	
	
	/*
	 * ----------------------------------------------------------------------- 
	 * <메뉴 추천>
	 * --------------------------------------------------------------------------
	 */
	
	/*
	 * ----------------------------------------------------------------------- 
	 * <월드컵>
	 * --------------------------------------------------------------------------
	 */
	
	
	
	
	

}
