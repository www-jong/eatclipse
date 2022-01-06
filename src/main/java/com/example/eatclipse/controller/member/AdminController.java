package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.member.AdminDAO;



@Controller 
@RequestMapping("/admin/*")  // 이게 클래스 위에 담겨져있으면 클래스안의 공통된 주소를 떼온겨)
// 클래스안에 공통으로 들어가는 /admin 을 나타냄. 즉, /admin/login.do 이렇게오면 받아들임
//다시 테스트
public class AdminController {

	@Inject
	AdminDAO adminDao;
	
	@RequestMapping("main.do")
	   public String main() {
	      return "admin/main";
	   }
	@RequestMapping("alllist.do")
	   public ModelAndView list(ModelAndView mav) {
	      mav.setViewName("/admin/all_list");
	      mav.addObject("list", adminDao.alllist());
	      return mav;
	   }
	@RequestMapping("list/{type}") //type을 전해받아 그 type의 
	   public ModelAndView list(@PathVariable("type") int type,ModelAndView mav) {
	 
		mav.setViewName("/admin/mem_list");
		if(type>=2)mav.addObject("list", adminDao.shoplist(type));
		else if(type==1)mav.addObject("list", adminDao.riderlist(type));
		else if(type==0)mav.addObject("list", adminDao.cuslist(type));
	      mav.addObject("t",type);
	      return mav;
	   }
		
	 @RequestMapping("delete/{no}")
	   public String delete(@PathVariable("no") int no) {
	     adminDao.delete(no);
	    
	      return "redirect:/admin/alllist.do";
	   }
	

	
}
