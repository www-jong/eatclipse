package com.example.eatclipse;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	  @RequestMapping(value = "/", method = RequestMethod.GET) public ModelAndView
	  home(ModelAndView mav,Locale locale, Model model,HttpSession session) {
	  logger.info("eatclipse실행시간 : {}.", locale);
	  
	  session.invalidate();
	  Date date = new Date(); 
	  DateFormat dateFormat =
	  DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	  String formattedDate = dateFormat.format(date);
	  model.addAttribute("serverTime", formattedDate );
	 
	  //세션 남아있는지 체크. 남아있으면 해당 main페이지로 이동
		/*
		 * Integer type=Integer.parseInt(String.valueOf(session.getAttribute("type")));
		 * if(String.valueOf(session.getAttribute("type")).equals(null)) {
		 * mav.setViewName("home"); return mav; } if(type==0) { //고객이라면 고객페이지로
		 * 
		 * mav.setViewName("redirect:/customer/main.do"); // views/customer/main.jsp
		 * }else if(type==1) { // 라이더페이지로 mav.setViewName("redirect:/rider/main.do"); //
		 * views/rider/main.jsp
		 * 
		 * }else if(type>=2&&type<=8) { //가게들은 가게페이지로
		 * 
		 * mav.setViewName("redirect:/shop/main.do"); // views/restaurant/main.jsp }else
		 * if(type==-1) { // 관리자라면 관리자페이지로
		 * 
		 * 
		 * mav.setViewName("redirect:/admin/main.do"); // views/rider/main.jsp } else {
		 * mav.setViewName("home"); }
		 */
	  mav.setViewName("home");
	  return mav; }
	 

}
