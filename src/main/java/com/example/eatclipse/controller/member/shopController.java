package com.example.eatclipse.controller.member;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.eatclipse.model.shop.productDAO;
import com.example.eatclipse.model.shop.productDTO;
@Controller 
@RequestMapping("/shop/*")//가게 등록수정, 메뉴등록 수정 작업용 
public class shopController {

	@Inject
	productDAO productdao;
	
	//메뉴리스트 //주문 목록 리스트
	@RequestMapping("main.do")
	public ModelAndView shopmain(ModelAndView mav, HttpSession session) {
		String name=(String) session.getAttribute("name");
		//System.out.println(name);
		mav.addObject("menulist", productdao.menu_list(name));
		mav.addObject("loglist", productdao.log_list());
		mav.setViewName("/shop/main");
		return mav;
	}
	
	//메뉴 등록 페이지로 넘기는 작업
	@RequestMapping("menu_register.do") // /eatclipse/shop/menu_register.do
	public String menu_register() {
	return "/shop/menu_register";
	}
	
	//메뉴 등록하는 작업
	@RequestMapping("insert.do")
	public String insert(productDTO dto, HttpServletRequest request, HttpSession session) {
		 String filename = "-"; //첨부파일 없을 때 빈칸 대신 -기호 사용(빈칸"" -> 오류 가능성ㅇ)
	      if (!dto.getFile1().isEmpty()) { //첨부파일이 있을 때
	         filename = dto.getFile1().getOriginalFilename();//파일이름
	         System.out.println("filename :"+filename);
	         System.out.println("file1 :"+dto.getFile1());
	         try {
	            //application 객체 생성(서버 전체에서 공유)
	            ServletContext application = request.getSession().getServletContext();
	            //실제 서비스 경로
	            String path = application.getRealPath("/WEB-INF/views/images/");
	            System.out.println("실제경로 :"+path);
	         
	            new File(path).mkdir(); //디렉토리 생성(디렉토리가 없을 경우)
	            //첨부파일이 지정된 디렉토리에 복사
	            dto.getFile1().transferTo(new File(path + filename));
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      dto.setImage(filename); //첨부파일 이름 저장
		dto.setShop_name((String) session.getAttribute("name")); //dto의 Shop_name에 세션의 name을 전달
		productdao.menu_insert(dto);
		return "redirect:/shop/main.do"; //insert 후 list로 넘김
	}
	
	
	//메뉴 수정
	@RequestMapping("menu_edit.do")// /eatclipse/shop/menu_edit.do
	public String menu_edit(productDTO dto, HttpServletRequest request) {
		productdao.menu_update(dto);
		return "redirect:/shop/main.do";
	}
	
	//메뉴 판매 상태 변경(type)
	@RequestMapping("menu_type_update.do")
	public String type_update(productDTO dto, HttpServletRequest request) {
		productdao.menu_type_update(dto);
		return "redirect:/shop/main.do";
	}
	
	//메뉴 삭제
	@RequestMapping("delete.do")
	public String delete(@PathVariable int no, HttpServletRequest request) {
		productdao.menu_delete(no);
		return "redirect:/shop/main.do";
	}
	
	
	
	
	//주문 진행 상태 변경
	@RequestMapping("status_update.do")
	public String status_update(productDTO dto, HttpServletRequest request) {
		
		return "redirect:/shop/main.do";
	}
}
