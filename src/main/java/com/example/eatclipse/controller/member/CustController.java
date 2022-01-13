package com.example.eatclipse.controller.member;

import java.util.ArrayList;
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
import com.example.eatclipse.model.shop.CartDTO;
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
	public ModelAndView main(ModelAndView mav, HttpSession session) {
		mav.setViewName("customer/main");
			//자기가 주문했던 log 들고옴
		  List<LogDTO> loglist= custDAO.userlog((String) session.getAttribute("userid"));
		  List<productDTO> plist=new ArrayList<productDTO>();
		  List<String> imagelist=new ArrayList<String>();
		  int count=0;
		  for(LogDTO list:loglist) {
			  //shop_name이 id로 되어있으므로 이를 name으로 대체해줌
			  list.setShop_name(custDAO.getshopname(list.getShop_name()));
		  	plist.addAll(custDAO.getrecent(list));
		  	count++;
		  	if(count>=5||count>=loglist.size())break;
		  } 
		  mav.addObject("recent_shoplist",plist);
		return mav;
	}

	/*-----------------------------------------------------------------
	회원이 main에서 [마이페이지] 버튼 누르면, 
	myPage.jsp로 이동하여 상세회원정보 보여주는 로직
	
	   * 이슈 : 충전 후, 다시 마이페이지 들어올 때 회원정보가 나타나지 않음!
	   * 과거 주문 내역 쭉 나오는 기능도 여기서 만들어야 하나?
	------------------------------------------------------------------*/

	@RequestMapping("myPage.do")
	public String myPage(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		model.addAttribute("dto", custDAO.view(userid));
		model.addAttribute("a", 1);
		model.addAttribute("list", custDAO.userlog(userid));
		return "customer/myPage";
	}

	@RequestMapping("myPageon.do")
	public String myPageon(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		model.addAttribute("dto", custDAO.view(userid));
		model.addAttribute("a", 2);
		model.addAttribute("list", custDAO.userlog(userid));
		return "customer/myPage";
	}

	/*-----------------------------------------------------------------
	회원이 마이페이지에서 회원 정보 수정
	------------------------------------------------------------------*/
	@RequestMapping("update.do")
	public ModelAndView update(@ModelAttribute CommonsDTO dto, HttpSession session, ModelAndView mav) {
		custDAO.update(dto);
		session.invalidate();
		mav.setViewName("commons/login");
		mav.addObject("message", "update_success");
		return mav;
	}

	@RequestMapping("delete.do")
	public ModelAndView delete(@RequestParam String userid, HttpSession session, ModelAndView mav) {

		custDAO.delete(userid);
		session.invalidate(); // 세션 초기화
		mav.setViewName("commons/login");
		mav.addObject("message", "delete_success");
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

		System.out.println(session.getAttribute("userid")+" 님이"+money+"만큼 충전하였습니다.");

		return "redirect:/customer/myPage.do";
	}

	/*
	 * ----------------------------------------------------------------------- 고객
	 * main에서 [한식], [양식], [분식] ... 버튼 눌러서 카테고리별 식당 리스트 확인 및 접근 1/10(월) 오전 일부 완성 -
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
	 * ----------------------------------------------------------------------- 식당
	 * 이름을 선택 시 각 식당의 메뉴 볼 수 확인 및 장바구니. * 망.... 확장 실패.
	 * --------------------------------------------------------------------------
	 */

	@RequestMapping("shopInfo.do")
	// PathVariable 쓰려면 {shop_name}으로 해야함.
	// 그런데 문제는 각 카테고리마다 식당 수도 다르고, 유동적으로 변해야 함.
	// 어케 해?ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	// --> httpservletrequest 사용.
	public ModelAndView menuList(HttpServletRequest request, HttpSession session, ModelAndView mav) {
		String shop_name = "";
		shop_name = request.getParameter("shop_name"); // 샵네임이 전달될경우
		String message = request.getParameter("message");

		// 가게이름으로 그 가게의 음식목록 불러오기(근데 품절이면 선택불가(.jsp에서구현)
		mav.addObject("productList", custDAO.menuList(shop_name));
		mav.addObject("shop_name", shop_name); // 가게이름만 따로 전달
		mav.addObject("message", message);
		mav.setViewName("/customer/shopInfo");
		return mav;
	}

	/*
	 * ----------------------------------------------------------------------- 장바구니
	 * - 주요 기능은 CartController
	 * --------------------------------------------------------------------------
	 */

	// 메인에서 [장바구니] 누르면 cart.jsp로 이동
	@RequestMapping("cart.do")
	public String cart() {
		return "customer/cart_list"; // 경로!
	}

	@RequestMapping("detail/{no}")
	public ModelAndView detail(@PathVariable("no") int no, ModelAndView mav, HttpSession session) {
		mav.setViewName("rider/order_detail");
		mav.addObject("list", custDAO.detail(no));
		return mav;
	}

	@RequestMapping("review_write/{no}")
	public ModelAndView review_write(@PathVariable("no") int no, ModelAndView mav, HttpSession session) {
		mav.setViewName("customer/review_write");
		// mav.addObject("list",custDAO.detail(no));
		mav.addObject("no", no);
		return mav;
	}

	@RequestMapping("review_set.do")
	public ModelAndView review_set(@ModelAttribute LogDTO dto, HttpSession session, ModelAndView mav) {
		System.out.println("리뷰작성내용 :" + dto.getReview());
		System.out.println("리뷰작성no :" + dto.getNo());
		mav.setViewName("customer/review_write");
		mav.addObject("check", "check");
		custDAO.review_set(dto);
		return mav;
	}

	@RequestMapping("review_view/{no}")
	public ModelAndView review_view(@PathVariable("no") int no, ModelAndView mav, HttpSession session) {
		mav.setViewName("customer/review_view");
		mav.addObject("review", custDAO.review_get(no));
		return mav;
	}

	@RequestMapping("recommendon")
	public ModelAndView recommendon(ModelAndView mav, HttpSession session) {
		System.out.println(session.getAttribute("name") + "님이 메뉴추천실행!");
		mav.setViewName("customer/recommend_menu");
		mav.addObject("count", 0);
		return mav;
	}

	@RequestMapping("recommend.do")
	public ModelAndView recommend(@RequestParam("count") int count, ModelAndView mav, HttpSession session) {
		mav.setViewName("customer/recommend_menu");
		mav.addObject("count", count);
		if (count == 7) {
			List<productDTO> nolist = custDAO.product_no();
			int a = (int) (Math.random() * nolist.size());
			int b = 0;
			for (productDTO list : nolist) {
				if (b == a) {
					mav.addObject("list", list);
					break;
				}
				b++;
			}
		}
		return mav;
	}
	
	
	@RequestMapping("worldcupon")
	public ModelAndView worldcupon(ModelAndView mav, HttpSession session) {
		System.out.println(session.getAttribute("name") + "님이 월드컵실행!");
		
		List<productDTO> nolist = custDAO.product_no(); //모든 product 목록(품절이아닌)
		List<Integer> productlist=new ArrayList<Integer>(); //랜덤한 16개의 음식을 담기위한 리스트
		List<productDTO> newlist=new ArrayList<productDTO>();
		System.out.println("실행되긴함"+nolist.size());
		int count=0;
			while(true) {
				int a = (int) ((Math.random() * nolist.size())+1); // no의 크기만큼에서 무작위숫자생성
				if (!productlist.contains(a)) 
				{ //같은값 있는지 확인
					productlist.add(a);
					System.out.print(a+", ");
					count++;
				}
				if(count==16)break;
			}
			System.out.println();
		count=0;
			for (productDTO list : nolist) {
				if(productlist.contains(count)) { //추출된 16개의 번호에 해당하는 product를 새롭게 객체화
					newlist.add(list);
				}
				count++;
				if(newlist.size()>=16)break;
			}
			mav.addObject("worldcuplist",newlist);
			mav.addObject("list_num",productlist);
			mav.setViewName("customer/worldcup");
			mav.addObject("count",0);
		return mav;
	}

// worldcuplist 객체를 html에서 콘트롤러로 다시 전달받기 어떻게..?
	@RequestMapping("worldcup.do")
	public ModelAndView worldcup(HttpServletRequest request,@RequestParam("count") int count,@RequestParam("worldcuplist") List<productDTO> worldcuplist, ModelAndView mav, HttpSession session) {
		String num = request.getParameter("num");
		mav.setViewName("customer/worldcup");
		mav.addObject("count", count);
		if(count==1) { // 처음 실행했을때,
			System.out.println("췤");
			int c=1;
			for (productDTO list : worldcuplist) {
				if(c==1) {mav.addObject("first_image",list.getImage());
				mav.addObject("first_product_name",list.getProduct_name());
				mav.addObject("first",list.getNo());
				}
				else if(c==2) {mav.addObject("second_image",list.getImage());
				mav.addObject("second_product_name",list.getProduct_name());
				mav.addObject("second",list.getNo());
				break;
				}
				c++;
			}
		}
		else { // 이후, 선택값제외 제거
			int c=1;
			if(num.equals("1"))worldcuplist.remove(1); // 1번골랐으면 2번을 지움
			else if(num.equals("2"))worldcuplist.remove(0); // 2번골랐으면 1번을 지움
			for (productDTO list : worldcuplist) {
				if(c==1) {mav.addObject("first_image",list.getImage());
				mav.addObject("first_product_name",list.getProduct_name());
				mav.addObject("first",list.getNo());
				}
				else if(c==2) {mav.addObject("second_image",list.getImage());
				mav.addObject("second_product_name",list.getProduct_name());
				mav.addObject("second",list.getNo());
				break;
				}
				c++;
			}
		}
		if(worldcuplist.size()==1) {
			for (productDTO list : worldcuplist) {
			mav.addObject("first_image",list.getImage());
			mav.addObject("first_product_name",list.getProduct_name());
			break;
			}
		}
		mav.addObject("worldcuplist",worldcuplist);
		return mav;
	}

}
