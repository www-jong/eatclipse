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
public class AdminController {

	@Inject
	AdminDAO adminDao;
	
	@RequestMapping("main.do")
	   public String main() {
	      return "admin/main";
	   }

	@RequestMapping("list/{type}") //type을 전해받아 그 type의 
	   public ModelAndView list(@PathVariable("type") int type,ModelAndView mav) {
	 
		mav.setViewName("/admin/mem_list");
		if(type>=2)mav.addObject("list", adminDao.shoplist(type));
		else if(type==1)mav.addObject("list", adminDao.riderlist(type));
		else if(type==0)mav.addObject("list", adminDao.cuslist(type));
		else if(type==-1)mav.addObject("list", adminDao.alllist());
	      mav.addObject("t",type);
	      return mav;
	   }
		
	 @RequestMapping("delete/{no}/{type}")
	   public String delete(@PathVariable("no") int no,@PathVariable("type") int type) { // 모든 유저목록에서 삭제수행 후, 다시 그페이지로 돌아감
	     adminDao.delete(no);
	      return "redirect:/admin/list/{type}";
	   }
	
	 @RequestMapping("loglist.do")
	   public ModelAndView loglist(ModelAndView mav) { //loglist페이지로 이동
	      mav.setViewName("/admin/loglist");
	      mav.addObject("list",adminDao.loglist());
		 return mav;
	   }
	 
	
}
