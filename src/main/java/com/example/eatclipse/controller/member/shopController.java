package com.example.eatclipse.controller.member;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.eatclipse.model.shop.productDAO;

@RequestMapping("/shop/*")//가게 등록수정, 메뉴등록 수정 작업용
public class shopController {

	@Inject
	productDAO productdao;
	
	@RequestMapping("register.do") //매핑값 eatclipse/
	public String register() {
		return "shop/shop_register"; //상품 등록 페이지
	}
}
