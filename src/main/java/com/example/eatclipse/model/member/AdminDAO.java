package com.example.eatclipse.model.member;

import java.util.List;

import com.example.eatclipse.model.commons.CommonsDTO;
import com.example.eatclipse.model.commons.LogDTO;
import com.example.eatclipse.model.shop.productDTO;





public interface AdminDAO {

		List<CommonsDTO> alllist(); // 등록된 모든 고객을 CommonsDTO형식으로 받아옴

		//상품삭제(관리자)
		void delete(int no);
		
		List<CommonsDTO> shoplist(int type);
		
		List<CommonsDTO> riderlist(int type);
		
		List<CommonsDTO> cuslist(int type);
	
		List<LogDTO> loglist();
	
		List<productDTO> productlist();
}
