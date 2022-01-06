package com.example.eatclipse.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.eatclipse.model.shop.productDAO;
import com.example.eatclipse.model.shop.productDTO;

@RequestMapping("/shop/*")//가게 등록수정, 메뉴등록 수정 작업용
public class shopController {

	@Inject
	productDAO productdao;
	
	//shop/main에서 가게 등록 전달받음
	@RequestMapping("register.do") //매핑값 /eatclipse/shop/register.do
	public String shop_register() {
		return "shop/shop_register"; //상품 등록 페이지
	}
	
	@RequestMapping("insert.do")
	public String insert(productDTO dto, HttpServletRequest request) {
		String fileName = "-"; //첨부파일 없을 때 빈칸 대신 -기호 사용(빈칸"" -> 오류 가능성ㅇ)
		if(!dto.getImage().isEmpty()) {
			fileName=dto.getImage();
		}// 이부분 잘 모르겠음 ㅜㅜ 파일명, getOriginalFileName? 은 어디다 쓰는걸까요
		return "redirect:/shop/detail.do";
	}
	
	@RequestMapping("detail.do") //매핑값 /eatclipse/shop/detail.do
	public String shop_detail() { 
		return "shop/shop_detail"; //가게 상세 페이지
	}
	
	@RequestMapping("menu_register.do") // /eatclipse/shop/menu_register.do
	public String menu_register() {
	return "shop/menu_register"; //가게 메뉴 등록페이지
	}
	
	@RequestMapping("menu_list.do") // /eatclipse/shop/menu_list.do
	public String menu_list() {
		return "shop/menu_list"; //메뉴 리스트..?-> 가게 상세 페이지에 있어야함
	}
	
	@RequestMapping("menu_edit")// /eatclipse/shop/menu_edit.do
	public String menu_edit() {
		return "shop/menu_edit";
	}
	
}
