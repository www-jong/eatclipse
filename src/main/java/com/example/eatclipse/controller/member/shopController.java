package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("main.do")
	public String shopmain() {
		return "/shop/main";
	}
	
	//메뉴 등록 페이지로 넘기는 작업
	@RequestMapping("menu_register.do") // /eatclipse/shop/menu_register.do
	public String menu_register() {
	return "/shop/menu_register";
	}
	
	//메뉴 등록하는 작업
	@RequestMapping("insert.do")
	public String insert(productDTO dto, HttpServletRequest request) {
		/* String fileName = "-"; //첨부파일 없을 때 빈칸 대신 -기호 사용(빈칸"" -> 오류 가능성ㅇ)
		 * if(!dto.getImage().isEmpty()) { fileName=dto.getImage(); }// 파일 첨부 다시 작업
		 */		
		productdao.menu_insert(dto);
		return "redirect:/shop/menu_list.do"; //insert 후 list로 넘김
	}
	
	//메뉴 리스트
	@RequestMapping("menu_list.do") // /eatclipse/shop/menu_list.do
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/menu_list");
		mav.addObject("menulist", productdao.menu_list());
		return mav;
	}
	
	//메뉴 수정
	@RequestMapping("menu_edit.do")// /eatclipse/shop/menu_edit.do
	public String menu_edit(productDTO dto, HttpServletRequest request) {
		productdao.menu_update(dto);
		return "redirect:/shop/menu_list.do";
	}
	
	//메뉴 판매 상태 변경(type)
	@RequestMapping("menu_type_update.do")
	public String type_update(productDTO dto, HttpServletRequest request) {
		productdao.menu_type_update(dto);
		return "redirect:/shop/menu_list.do";
	}
	
	//메뉴 삭제
	@RequestMapping("delete.do")
	public String delete(@PathVariable int no, HttpServletRequest request) {
		productdao.menu_delete(no);
		return "redirect:/shop/menu_list.do";
	}
}
